package com.example.taskifyapi.controller;

import com.example.taskifyapi.dto.UserDto;
import com.example.taskifyapi.dto.requests.user.UserRequest;
import com.example.taskifyapi.service.user.UserService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("Users")
public class UserController {

  private final UserService userService;

  @GetMapping("/getAll")
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok(userService.getAll());
  }

  @PutMapping("/updateBy/{id}")
  ResponseEntity<UserDto> updateById(
      @PathVariable(name = "id") UUID id, @RequestBody UserRequest request) {
    return ResponseEntity.ok(userService.updateUser(request, id));
  }

  @GetMapping("/getUserBy/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") UUID id) {
    return ResponseEntity.ok(userService.getById(id));
  }

  @DeleteMapping("/deleteUserBy/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable(name = "id") UUID id) {
    userService.deleteById(id);
  }
}
