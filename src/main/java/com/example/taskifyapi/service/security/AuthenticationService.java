package com.example.taskifyapi.service.security;

import com.example.taskifyapi.Dto.security.AuthenticationResponse;
import com.example.taskifyapi.entity.UserEntity;

public interface AuthenticationService {
  AuthenticationResponse register(UserEntity request);

  AuthenticationResponse authenticate(UserEntity request);
}
