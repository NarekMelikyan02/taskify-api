package com.example.taskifyapi.Dto;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.entity.enums.UserGender;
import com.example.taskifyapi.entity.enums.UserRoles;
import lombok.Builder;

import java.util.List;
import java.util.UUID;
@Builder
public record UserDto(
        UUID Id,
        String firstName,
        String lastName,
        String email,
        UserRoles role,
        UserGender gender,
        List<TaskEntity> asignedTasks

) {
}
