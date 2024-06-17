package com.example.taskifyapi.service.event.handlers.impl;

import com.example.taskifyapi.entity.TaskAnswerEntity;
import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.repository.TaskAnswerEntityRepository;
import com.example.taskifyapi.service.event.handlers.EventHandler;
import com.example.taskifyapi.service.event.model.event_types.TaskDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("TASK_DELETED")
@RequiredArgsConstructor
public class TaskDeletedEventHandler implements EventHandler<TaskDeletedEvent> {

  private final TaskAnswerEntityRepository answerRepository;

  @Override
  public void handle(TaskDeletedEvent eventModel) {
    TaskEntity deletedTask = eventModel.getDeletedTask();
    TaskAnswerEntity answer = deletedTask.getAnswer();
    answer.setDeleted(deletedTask.getDeleted());
    answerRepository.save(answer);
  }
}
