package com.example.taskifyapi.service.task;

import com.example.taskifyapi.Dto.TaskDto;
import com.example.taskifyapi.Dto.requests.TaskRequest;
import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.entity.enums.TaskStatus;
import com.example.taskifyapi.exeptions.TaskNotFoundException;
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
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;
  private final UserRepository userRepository;

  public TaskDto addTask(TaskRequest request) {
    TaskEntity task = new TaskEntity();
    task.setTitle(request.title());
    task.setContent(request.content());
    task.setPriority(request.priority());
    task.setCreated(LocalDateTime.now());
    task.setStatus(TaskStatus.CREATED);
    task = taskRepository.save(task);
    return TaskMapper.map(task);
  }

  public void deleteById(final UUID id) {
    TaskEntity task =
        taskRepository
            .findByIdAndDeletedIsNull(id)
            .orElseThrow(
                () -> {
                  log.error("Task not found by provided id{} ", id);
                  return new TaskNotFoundException("Task not found");
                });
    task.setDeleted(LocalDateTime.now());
    task = taskRepository.save(task);
    log.info("Successfully deleted task {}", task.getId());
  }
}
