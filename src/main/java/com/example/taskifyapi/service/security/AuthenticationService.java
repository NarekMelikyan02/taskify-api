package com.example.taskifyapi.service.security;

import com.example.taskifyapi.dto.security.AuthenticationResponse;
import com.example.taskifyapi.entity.UserEntity;

public interface AuthenticationService {
  AuthenticationResponse register(UserEntity request);

  AuthenticationResponse authenticate(UserEntity request);
}
