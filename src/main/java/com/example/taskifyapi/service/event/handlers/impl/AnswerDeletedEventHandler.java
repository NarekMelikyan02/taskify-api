package com.example.taskifyapi.service.event.handlers.impl;

import com.example.taskifyapi.enumeration.AssignStatus;
import com.example.taskifyapi.repository.TaskEntityRepository;
import com.example.taskifyapi.service.event.handlers.EventHandler;
import com.example.taskifyapi.service.event.model.AnswerDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("ANSWER_DELETED")
@RequiredArgsConstructor
public class AnswerDeletedEventHandler implements EventHandler<AnswerDeletedEvent> {

  private final TaskEntityRepository taskRepository;

  @Override
  public void handle(AnswerDeletedEvent eventModel) {
    taskRepository
        .findByAnswer_IdAndDeletedIsNull(eventModel.getAnswerId())
        .ifPresent(
            entity -> {
              entity.setAnswer(null);
              entity.setStatus(AssignStatus.ASSIGNED);
              taskRepository.save(entity);
            });
  }
}
