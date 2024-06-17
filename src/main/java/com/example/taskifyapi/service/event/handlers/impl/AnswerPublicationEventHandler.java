package com.example.taskifyapi.service.event.handlers.impl;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.enumeration.AssignStatus;
import com.example.taskifyapi.exeptions.TaskNotFoundException;
import com.example.taskifyapi.repository.TaskEntityRepository;
import com.example.taskifyapi.service.event.handlers.EventHandler;
import com.example.taskifyapi.service.event.model.AnswerPublishedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component("ANSWER_PUBLISHED")
public class AnswerPublicationEventHandler implements EventHandler<AnswerPublishedEvent> {

  private final TaskEntityRepository taskRepository;

  @Override
  public void handle(AnswerPublishedEvent eventModel) {
    TaskEntity task =
        taskRepository
            .findByTitleAndContentAndDeletedIsNull(eventModel.getTitle(), eventModel.getContent())
            .orElseThrow(
                () -> {
                  log.error(
                      "Task not found by provided title: {} and content: {}",
                      eventModel.getTitle(),
                      eventModel.getContent());
                  return new TaskNotFoundException("");
                });
    task.setStatus(AssignStatus.COMPLETED);
    task.setAnswer(eventModel.getAnswer());
    taskRepository.save(task);
  }
}
