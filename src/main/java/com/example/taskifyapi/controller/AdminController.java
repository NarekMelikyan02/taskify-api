package com.example.taskifyapi.controller;

import com.example.taskifyapi.Dto.UserDto;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.service.AdminService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "Admins")
public class AdminController {
  private final AdminService userService;

  @GetMapping("/getUsers")
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/getUserBy/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
    return ResponseEntity.ok(userService.getById(id));
  }

  @PutMapping("/giveAuthorities")
  public ResponseEntity<Void> giveAuthorities(@RequestBody UserEntity request) {
    userService.giveAuthorities(request);
    return new ResponseEntity<>(HttpStatusCode.valueOf(200));
  }

  @DeleteMapping("/deleteUserBy/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
    userService.deleteById(id);
    return new ResponseEntity<>(HttpStatusCode.valueOf(204));
  }
}
