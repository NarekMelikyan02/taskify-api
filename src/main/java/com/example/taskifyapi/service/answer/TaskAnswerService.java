package com.example.taskifyapi.service.answer;

import com.example.taskifyapi.dto.task_answer.TaskAnswerDto;
import com.example.taskifyapi.dto.task_answer.TaskAnswerRequest;
import java.util.List;

public interface TaskAnswerService {
  List<TaskAnswerDto> getAll();

  TaskAnswerDto addAnswer(TaskAnswerRequest request);
}
