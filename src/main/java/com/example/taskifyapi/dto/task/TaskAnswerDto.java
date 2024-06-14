package com.example.taskifyapi.dto.task;

import com.example.taskifyapi.entity.TaskEntity;
import lombok.Builder;

import java.util.UUID;

@Builder
public record TaskAnswerDto(UUID id, String answer, TaskEntity answerOf) {
}
