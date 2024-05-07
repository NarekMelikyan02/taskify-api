package com.example.taskifyapi.dto.task;

import com.example.taskifyapi.entity.enums.TaskPriority;

public record TaskRequest(String title, String content, TaskPriority priority) {}
