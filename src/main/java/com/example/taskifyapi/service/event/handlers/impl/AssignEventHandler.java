package com.example.taskifyapi.service.event.handlers.impl;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.exeptions.TaskNotFoundException;
import com.example.taskifyapi.repository.TaskEntityRepository;
import com.example.taskifyapi.repository.UserEntityRepository;
import com.example.taskifyapi.service.event.handlers.EventHandler;
import com.example.taskifyapi.service.event.model.TaskAssignedEvent;
import com.example.taskifyapi.service.user.UserFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("TASK_ASSIGNED")
@RequiredArgsConstructor
public class AssignEventHandler implements EventHandler<TaskAssignedEvent> {

  private final UserEntityRepository userRepository;
  private final TaskEntityRepository taskRepository;
  private final UserFetcher userFetcher;

  @Override
  public void handle(TaskAssignedEvent eventModel) {
    TaskEntity task =
        taskRepository
            .findByIdAndDeletedIsNull(eventModel.getTaskId())
            .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    UserEntity user = userFetcher.fetch(eventModel.getUserEmail());
    task.setAssignedTo(user);
    taskRepository.save(task);
    userRepository.save(user);
  }
}
