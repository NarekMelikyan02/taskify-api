package com.example.taskifyapi.service.event.model;

import com.example.taskifyapi.enumeration.ListenersEventType;
import com.example.taskifyapi.service.event.EventModel;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TaskAssignedEvent implements EventModel {
  private String userEmail;
  private UUID taskId;
  private ListenersEventType eventType;
}
