package com.example.taskifyapi.service.event.listeners;

import com.example.taskifyapi.service.event.handlers.EventHandlerFactory;
import com.example.taskifyapi.service.event.model.event_types.RegularEventModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegularEventsListener {
  private final EventHandlerFactory eventHandlerFactory;

  @EventListener
  public void handleTaskAssignedEvent(RegularEventModel event) {
    eventHandlerFactory.getHandler(event.getEventType()).handle(event);
  }
}
