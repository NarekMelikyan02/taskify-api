package com.example.taskifyapi.service.event.listeners;

import com.example.taskifyapi.service.event.handlers.EventHandlerFactory;
import com.example.taskifyapi.service.event.model.EventModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskAssignedEventListener {

  private final EventHandlerFactory eventHandlerFactory;

  @EventListener
  @Transactional
  public void handleTaskAssignedEvent(EventModel event) {
    eventHandlerFactory.getHandler(event.getEventType()).handle(event);
  }
}
