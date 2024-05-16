package com.example.taskifyapi.service.event.handlers;

import com.example.taskifyapi.service.event.EventModel;

public interface EventHandler<T extends EventModel> {
  void handle(T eventModel);
}