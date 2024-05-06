package com.example.taskifyapi.service.user;

import com.example.taskifyapi.Dto.UserDto;
import com.example.taskifyapi.Dto.requests.UserRequest;
import java.util.List;
import java.util.UUID;

public interface UserService {
  UserDto updateUser(UserRequest request, final UUID id);

  List<UserDto> getAll();

  UserDto getById(UUID id);

  void deleteById(UUID id);
}
