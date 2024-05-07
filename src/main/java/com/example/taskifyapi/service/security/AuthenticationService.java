package com.example.taskifyapi.service.security;

import com.example.taskifyapi.dto.security.AuthenticationResponse;
import com.example.taskifyapi.dto.security.LoginRequest;
import com.example.taskifyapi.dto.security.RegisterRequest;

public interface AuthenticationService {
  AuthenticationResponse register(RegisterRequest request);

  AuthenticationResponse authenticate(LoginRequest request);
}
