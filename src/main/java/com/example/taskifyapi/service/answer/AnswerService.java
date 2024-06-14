package com.example.taskifyapi.service.answer;

import com.example.taskifyapi.dto.task.TaskAnswerDto;

import java.util.List;

public interface AnswerService {
    List<TaskAnswerDto> getAll();
}
