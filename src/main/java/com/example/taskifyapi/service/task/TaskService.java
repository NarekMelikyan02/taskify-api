package com.example.taskifyapi.service.task;

import com.example.taskifyapi.dto.task.TaskDto;
import com.example.taskifyapi.dto.task.TaskRequest;
import com.example.taskifyapi.dto.task.UpdateRequest;
import java.util.List;
import java.util.UUID;

public interface TaskService {
  TaskDto addTask(TaskRequest taskEntity);

  void deleteById(final UUID id);

  List<TaskDto> getAll();

  TaskDto updateTask(UUID id, UpdateRequest request);

  TaskDto getByID(UUID id);
}
