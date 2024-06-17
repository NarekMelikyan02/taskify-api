package com.example.taskifyapi.service.task.answer;

import com.example.taskifyapi.dto.task_answer.TaskAnswerDto;
import com.example.taskifyapi.entity.TaskAnswerEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskAnswerMapper {
  public TaskAnswerDto map(TaskAnswerEntity taskAnswer) {
    return TaskAnswerDto.builder().id(taskAnswer.getId()).answer(taskAnswer.getAnswer()).build();
  }
}
