package com.example.taskifyapi.controller;

import com.example.taskifyapi.dto.task.TaskDto;
import com.example.taskifyapi.dto.task.TaskRequest;
import com.example.taskifyapi.dto.task.UpdateRequest;
import com.example.taskifyapi.service.task.TaskService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Tasks")
@RequiredArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @GetMapping("getBy/{id}")
  ResponseEntity<TaskDto> getById(@PathVariable(name = "id") final UUID id) {
    return ResponseEntity.ok(taskService.getByID(id));
  }

  @GetMapping("/getAll")
  ResponseEntity<List<TaskDto>> getAll() {
    return ResponseEntity.ok(taskService.getAll());
  }

  @PutMapping("/updateBy/{id}")
  ResponseEntity<TaskDto> updateById(
      @PathVariable(name = "id") final UUID id, @RequestBody UpdateRequest request) {
    return ResponseEntity.ok(taskService.updateTask(id, request));
  }

  @PostMapping("/add")
  public ResponseEntity<TaskDto> addTask(@RequestBody TaskRequest request) {
    return ResponseEntity.ok(taskService.addTask(request));
  }

  @DeleteMapping("/deleteBy/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable(name = "id") UUID id) {
    taskService.deleteById(id);
  }
}
