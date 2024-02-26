package com.example.taskifyapi.Dto;

import com.example.taskifyapi.entity.enums.TaskPriority;
import lombok.Builder;

@Builder
public record TaskDto(String title, String content, TaskPriority taskPriority) {}
