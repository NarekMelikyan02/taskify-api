package com.example.taskifyapi.exeptions;

public class TaskNotFoundException extends RuntimeException {
  public TaskNotFoundException(String message) {
    super(message);
  }
}
