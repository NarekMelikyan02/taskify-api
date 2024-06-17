package com.example.taskifyapi.dto.task_answer;

import lombok.Builder;

import java.util.UUID;

@Builder
public record TaskAnswerDto(UUID id, String answer) {}
