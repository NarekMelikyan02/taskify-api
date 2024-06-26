package com.example.taskifyapi.controller;

import com.example.taskifyapi.dto.security.AuthenticationResponse;
import com.example.taskifyapi.dto.security.LoginRequest;
import com.example.taskifyapi.dto.security.RegisterRequest;
import com.example.taskifyapi.service.security.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "Authentication")
public class AuthController {

  private final AuthenticationServiceImpl authService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.authenticate(request));
  }
}
