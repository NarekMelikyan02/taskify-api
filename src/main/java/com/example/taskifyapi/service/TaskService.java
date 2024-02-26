package com.example.taskifyapi.service;

import com.example.taskifyapi.Dto.TaskDto;
import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.repository.TaskRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

  private final TaskRepository taskRepository;

  private TaskDto taskMapper(final TaskEntity taskEntity) {
    return TaskDto.builder()
        .title(taskEntity.getTitle())
        .content(taskEntity.getContent())
        .taskPriority(taskEntity.getPriority())
        .build();
  }

  public void addTask(TaskEntity taskEntity) {
    TaskEntity task = new TaskEntity();
    task.setTitle(taskEntity.getTitle());
    task.setContent(taskEntity.getContent());
    task.setPriority(taskEntity.getPriority());
    task.setCreated(LocalDateTime.now());
    taskRepository.save(task);
  }
}
