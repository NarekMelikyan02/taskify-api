package com.example.taskifyapi.dto.task;

import com.example.taskifyapi.enumeration.task.TaskPriority;

public record UpdateRequest(String title, String content, TaskPriority priority) {}
