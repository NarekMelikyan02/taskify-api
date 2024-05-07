package com.example.taskifyapi.service.task;

import com.example.taskifyapi.dto.TaskDto;
import com.example.taskifyapi.entity.TaskEntity;

public class TaskMapper {
  public static TaskDto map(TaskEntity taskEntity) {
    return TaskDto.builder()
        .id(taskEntity.getId())
        .title(taskEntity.getTitle())
        .content(taskEntity.getContent())
        .taskPriority(taskEntity.getPriority())
        .taskStatus(taskEntity.getStatus())
        .build();
  }
}
