package com.example.taskifyapi.controller;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.service.TaskService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Tasks")
@RequiredArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @PostMapping("/create")
  public ResponseEntity<Void> addTask(@RequestBody TaskEntity request) {
    taskService.addTask(request);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/deleteBy/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
    taskService.deleteById(id);
    return new ResponseEntity<>(HttpStatusCode.valueOf(204));
  }
}
