package com.example.taskifyapi.service.event.handlers;

import com.example.taskifyapi.enumeration.ListenersEventType;
import com.example.taskifyapi.service.event.model.EventModel;

public interface EventHandlerFactory {
  EventHandler<EventModel> getHandler(ListenersEventType eventType);
}
