package com.example.taskifyapi.dto.task_answer;

import java.util.UUID;
import lombok.Builder;

@Builder
public record TaskAnswerDto(UUID id, String answer) {}
