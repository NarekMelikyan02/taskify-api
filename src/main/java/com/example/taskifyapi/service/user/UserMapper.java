package com.example.taskifyapi.service.user;

import com.example.taskifyapi.dto.UserDto;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.service.task.TaskMapper;

public class UserMapper {
  public static UserDto map(UserEntity user) {
    return UserDto.builder()
        .Id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .role(user.getRole())
        .gender(user.getGender())
        .assignedTasks(user.getAssignedTasks().stream().map(TaskMapper::map).toList())
        .build();
  }
}
