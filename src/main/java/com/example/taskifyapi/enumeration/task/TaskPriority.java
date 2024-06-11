package com.example.taskifyapi.enumeration.task;

import lombok.Getter;

@Getter
public enum TaskPriority {
  HIGH(3),
  MEDIUM(2),
  LOW(1);
  private final int level;

  TaskPriority(int level) {
    this.level = level;
  }
}
