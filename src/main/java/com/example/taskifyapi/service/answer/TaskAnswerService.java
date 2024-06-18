package com.example.taskifyapi.service.answer;

import com.example.taskifyapi.dto.task_answer.TaskAnswerDto;
import com.example.taskifyapi.dto.task_answer.TaskAnswerRequest;
import java.util.List;
import java.util.UUID;

public interface TaskAnswerService {
  List<TaskAnswerDto> getAll();

  TaskAnswerDto addAnswer(TaskAnswerRequest request);

  void deleteAnswerById(UUID id);
}
