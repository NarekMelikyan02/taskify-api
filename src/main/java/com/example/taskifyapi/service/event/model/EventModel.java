package com.example.taskifyapi.service.event.model;

import com.example.taskifyapi.enumeration.ListenersEventType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class EventModel {
  ListenersEventType eventType;
}
