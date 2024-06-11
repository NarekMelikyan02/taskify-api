package com.example.taskifyapi.dto.task;

import com.example.taskifyapi.enumeration.AssignStatus;
import com.example.taskifyapi.enumeration.task.TaskPriority;
import java.util.UUID;
import lombok.Builder;

@Builder
public record TaskDto(
    UUID id, String title, String content, TaskPriority taskPriority, AssignStatus taskStatus) {}
