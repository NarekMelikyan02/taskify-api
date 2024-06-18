package com.example.taskifyapi.service.event.model;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.service.event.model.event_types.RegularEventModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class TaskDeletedEvent extends RegularEventModel {
  private final TaskEntity deletedTask;
}
