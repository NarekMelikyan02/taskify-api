package com.example.taskifyapi.controller;

import com.example.taskifyapi.Dto.TaskDto;
import com.example.taskifyapi.Dto.requests.TaskRequest;
import com.example.taskifyapi.service.task.TaskService;
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

  @PostMapping("/create")
  public ResponseEntity<TaskDto> addTask(@RequestBody TaskRequest request) {
    return ResponseEntity.ok(taskService.addTask(request));
  }

  @DeleteMapping("/deleteBy/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable UUID id) {
    taskService.deleteById(id);
  }
}
