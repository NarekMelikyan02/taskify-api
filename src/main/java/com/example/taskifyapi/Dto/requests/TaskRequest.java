package com.example.taskifyapi.Dto.requests;

import com.example.taskifyapi.entity.enums.TaskPriority;

public record TaskRequest(String title, String content, TaskPriority priority) {}
