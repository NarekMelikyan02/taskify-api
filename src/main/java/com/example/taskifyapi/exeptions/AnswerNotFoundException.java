package com.example.taskifyapi.exeptions;

public class AnswerNotFoundException extends RuntimeException {
  public AnswerNotFoundException(String message) {
    super(message);
  }
}
