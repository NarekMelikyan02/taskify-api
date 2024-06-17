package com.example.taskifyapi.service.event.listeners;

import com.example.taskifyapi.service.event.handlers.EventHandlerFactory;
import com.example.taskifyapi.service.event.model.event_types.TransaCtionalEventModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionalEventsListener {

  private final EventHandlerFactory eventHandlerFactory;

  @EventListener
  @Transactional
  public void handleTaskAssignedEvent(TransaCtionalEventModel event) {
    eventHandlerFactory.getHandler(event.getEventType()).handle(event);
  }
}
