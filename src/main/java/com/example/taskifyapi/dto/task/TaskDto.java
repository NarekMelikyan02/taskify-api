package com.example.taskifyapi.dto.task;

import com.example.taskifyapi.entity.enums.AssignStatus;
import com.example.taskifyapi.entity.enums.TaskPriority;
import java.util.UUID;
import lombok.Builder;

@Builder
public record TaskDto(
    UUID id, String title, String content, TaskPriority taskPriority, AssignStatus taskStatus) {}
