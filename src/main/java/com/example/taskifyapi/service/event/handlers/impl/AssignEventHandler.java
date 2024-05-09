package com.example.taskifyapi.service.event.handlers.impl;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.exeptions.TaskNotFoundException;
import com.example.taskifyapi.exeptions.UserNotFoundException;
import com.example.taskifyapi.repository.TaskEntityRepository;
import com.example.taskifyapi.repository.UserEntityRepository;
import com.example.taskifyapi.service.event.handlers.EventHandler;
import com.example.taskifyapi.service.event.model.TaskAssignedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("TASK_ASSIGNED")
@RequiredArgsConstructor
public class AssignEventHandler implements EventHandler<TaskAssignedEvent> {

  private final UserEntityRepository userRepository;
  private final TaskEntityRepository taskRepository;

  @Override
  public void handle(TaskAssignedEvent eventModel) {
    TaskEntity task =
        taskRepository
            .findByIdAndDeletedIsNull(eventModel.getTaskId())
            .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    UserEntity user =
        userRepository
            .findUserEntityByEmailAndDeletedIsNull(eventModel.getUserEmail())
            .orElseThrow(() -> new UserNotFoundException("User not found"));
    task.setAssignedTo(user);
    taskRepository.save(task);
    userRepository.save(user);
  }
}
