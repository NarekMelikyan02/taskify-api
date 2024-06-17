package com.example.taskifyapi.service.event.model.event_types;

import com.example.taskifyapi.entity.TaskEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class TaskDeletedEvent extends RegularEventModel {
  private final TaskEntity deletedTask;
}
