package com.example.taskifyapi.service.task;

import com.example.taskifyapi.Dto.TaskDto;
import com.example.taskifyapi.Dto.requests.TaskRequest;
import java.util.UUID;

public interface TaskService {
  TaskDto addTask(TaskRequest taskEntity);

  void deleteById(final UUID id);
}
