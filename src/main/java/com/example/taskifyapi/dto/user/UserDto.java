package com.example.taskifyapi.dto.user;

import com.example.taskifyapi.dto.task.TaskDto;
import com.example.taskifyapi.entity.enums.UserGender;
import com.example.taskifyapi.entity.enums.UserRoles;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public record UserDto(
    UUID Id,
    String firstName,
    String lastName,
    String email,
    UserRoles role,
    UserGender gender,
    List<TaskDto> assignedTasks) {}
