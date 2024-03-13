package com.example.taskifyapi.controller;

import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.model.AuthenticationResponse;
import com.example.taskifyapi.service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("Users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
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

  @PutMapping("updateBy/{id}")
  ResponseEntity<Void> updateById(@PathVariable UUID id, @RequestBody UserEntity request) {
    userService.updateUser(request, id);
    return new ResponseEntity<>(HttpStatusCode.valueOf(200));
  }
}
