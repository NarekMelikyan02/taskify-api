package com.example.taskifyapi.service;

import com.example.taskifyapi.Dto.TaskDto;
import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.entity.enums.TaskStatus;
import com.example.taskifyapi.repository.TaskRepository;
import com.example.taskifyapi.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

  private final TaskRepository taskRepository;
  private final UserRepository userRepository;

  TaskDto taskMapper(final TaskEntity taskEntity) {
    return TaskDto.builder()
        .id(taskEntity.getId())
        .title(taskEntity.getTitle())
        .content(taskEntity.getContent())
        .taskPriority(taskEntity.getPriority())
        .taskStatus(taskEntity.getStatus())
        .build();
  }

  public void addTask(final TaskEntity taskEntity) {
    TaskEntity task = new TaskEntity();
    task.setTitle(taskEntity.getTitle());
    task.setContent(taskEntity.getContent());
    task.setPriority(taskEntity.getPriority());
    task.setStatus(TaskStatus.ASSIGNED);
    task.setAsignedTo(userRepository.getReferenceById(taskEntity.getAsignedTo().getId()));
    task.setCreated(LocalDateTime.now());

    taskRepository.save(task);
  }

  public void deleteById(UUID id) {
    if (taskRepository.findById(id).isPresent()) taskRepository.deleteById(id);
    else log.error("Task with id: {} doesn't exist", id);
  }
}
