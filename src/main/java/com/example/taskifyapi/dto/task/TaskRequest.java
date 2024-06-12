package com.example.taskifyapi.dto.task;

import com.example.taskifyapi.enumeration.task.TaskPriority;

public record TaskRequest(
    String title, String content, TaskPriority priority, String assigneeEmail) {}
