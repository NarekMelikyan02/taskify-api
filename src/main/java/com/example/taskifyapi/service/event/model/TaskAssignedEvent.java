package com.example.taskifyapi.service.event.model;

import com.example.taskifyapi.service.event.model.event_types.TransaCtionalEventModel;
import java.util.UUID;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class TaskAssignedEvent extends TransaCtionalEventModel {
  private String userEmail;
  private UUID taskId;
}
