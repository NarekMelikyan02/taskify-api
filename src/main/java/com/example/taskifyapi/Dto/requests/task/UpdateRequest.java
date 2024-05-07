package com.example.taskifyapi.Dto.requests.task;

import com.example.taskifyapi.entity.enums.TaskPriority;

public record UpdateRequest(String title, String content, TaskPriority priority) {}
