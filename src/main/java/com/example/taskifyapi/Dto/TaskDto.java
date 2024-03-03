package com.example.taskifyapi.Dto;

import com.example.taskifyapi.entity.enums.TaskPriority;
import com.example.taskifyapi.entity.enums.TaskStatus;
import java.util.UUID;
import lombok.Builder;

@Builder
public record TaskDto(
    UUID id, String title, String content, TaskPriority taskPriority, TaskStatus taskStatus) {}
