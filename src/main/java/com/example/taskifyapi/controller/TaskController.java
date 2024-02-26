package com.example.taskifyapi.controller;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Tasks")
@RequiredArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @PostMapping("/create")
  public ResponseEntity<Void> addTask(@RequestBody TaskEntity taskEntity) {
    taskService.addTask(taskEntity);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
