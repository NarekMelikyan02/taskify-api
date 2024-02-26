package com.example.taskifyapi.controller;

import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.model.AuthenticationResponse;
import com.example.taskifyapi.service.SecurityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

  private final SecurityService userService;

  public SecurityController(SecurityService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody UserEntity request) {
    return ResponseEntity.ok(userService.register(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> login(@RequestBody UserEntity request) {
    return ResponseEntity.ok(userService.authenticate(request));
  }
}
