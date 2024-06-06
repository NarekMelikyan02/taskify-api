package com.example.taskifyapi.service.event.model;

import java.util.UUID;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class TaskAssignedEvent extends EventModel {
  private String userEmail;
  private UUID taskId;
}
