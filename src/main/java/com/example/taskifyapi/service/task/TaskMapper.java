package com.example.taskifyapi.service.task;

import com.example.taskifyapi.dto.task.TaskDto;
import com.example.taskifyapi.entity.TaskEntity;

public class TaskMapper {
  public static TaskDto map(TaskEntity taskEntity) {
    return TaskDto.builder()
        .id(taskEntity.getId())
        .title(taskEntity.getTitle())
        .taskPriority(taskEntity.getPriority())
        .content(taskEntity.getContent())
        .answer(taskEntity.getAnswer())
        .taskStatus(taskEntity.getStatus())
        .build();
  }
}
