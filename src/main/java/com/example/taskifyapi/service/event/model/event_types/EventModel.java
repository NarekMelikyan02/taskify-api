package com.example.taskifyapi.service.event.model.event_types;

import com.example.taskifyapi.enumeration.ListenersEventType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class EventModel {
  private ListenersEventType eventType;
}
