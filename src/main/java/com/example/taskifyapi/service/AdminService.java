package com.example.taskifyapi.service;

import com.example.taskifyapi.Dto.UserDto;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.exeptions.UserNotFoundException;
import com.example.taskifyapi.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

  private final UserRepository userRepository;

  public void giveAuthorities(final UserEntity request) {
    UserEntity user =
        userRepository
            .findByEmail(request.getEmail())
            .orElseThrow(() -> new UserNotFoundException("Not such user exists"));
    user.setRole(request.getRole());
    log.info("User role was set to {}", user.getRole());
    userRepository.save(user);
  }

  public List<UserDto> getAllUsers() {
    return userRepository.findAll().stream().map(this::userMapper).toList();
  }

  private UserDto userMapper(final UserEntity user) {
    return UserDto.builder()
        .Id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .role(user.getRole())
        .gender(user.getGender())
        .asignedTasks(user.getAsignedTasks())
        .build();
  }

  public UserDto getById(final UUID id) {
    return userMapper(
        userRepository
            .findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found by provided id" + id)));
  }

  public void deleteById(final UUID id) {
    if (userRepository.findById(id).isPresent()) {
      userRepository.deleteById(id);
    } else {
      log.error("User by given id :{} doesn't exist", id);
    }
  }
}
