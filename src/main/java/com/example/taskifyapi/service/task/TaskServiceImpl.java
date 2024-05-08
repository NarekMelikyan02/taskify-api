package com.example.taskifyapi.service.task;

import com.example.taskifyapi.dto.task.TaskDto;
import com.example.taskifyapi.dto.task.TaskRequest;
import com.example.taskifyapi.dto.task.UpdateRequest;
import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.exeptions.TaskNotFoundException;
import com.example.taskifyapi.repository.TaskEntityRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskEntityRepository taskRepository;

  @Override
  @Transactional
  public TaskDto addTask(TaskRequest request) {
    TaskEntity task = new TaskEntity();
    task.setTitle(request.title());
    task.setContent(request.content());
    task.setPriority(request.priority());
    task.setCreated(LocalDateTime.now());
    task = taskRepository.save(task);
    return TaskMapper.map(task);
  }

  @Override
  @Transactional
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

  @Override
  public List<TaskDto> getAll() {
    List<TaskEntity> allTasks = taskRepository.findAllByDeletedIsNull();
    return allTasks.stream().map(TaskMapper::map).toList();
  }

  @Override
  @Transactional
  public TaskDto updateTask(final UUID id, UpdateRequest request) {
    TaskEntity task =
        taskRepository
            .findByIdAndDeletedIsNull(id)
            .orElseThrow(
                () -> {
                  log.error("Task not found by provided id{} ", id);
                  return new TaskNotFoundException("Task not found");
                });

    task.setTitle(request.title());
    task.setContent(request.content());
    task.setPriority(request.priority());
    task.setUpdated(LocalDateTime.now());
    task = taskRepository.save(task);
    log.info("Successfully updated task{} ", task.getId());
    return TaskMapper.map(task);
  }

  @Override
  public TaskDto getByID(final UUID id) {
    TaskEntity task =
        taskRepository
            .findByIdAndDeletedIsNull(id)
            .orElseThrow(
                () -> {
                  log.error("Can't find task {}", id);
                  return new TaskNotFoundException("");
                });
    return TaskMapper.map(task);
  }
}
