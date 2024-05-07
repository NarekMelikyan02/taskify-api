package com.example.taskifyapi.dto.task;

import com.example.taskifyapi.entity.enums.TaskPriority;

public record UpdateRequest(String title, String content, TaskPriority priority) {}
