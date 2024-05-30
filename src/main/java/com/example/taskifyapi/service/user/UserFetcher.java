package com.example.taskifyapi.service.user;

import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.exeptions.UserNotFoundException;
import com.example.taskifyapi.repository.UserEntityRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserFetcher {

  private final UserEntityRepository repository;

  public UserEntity fetch(String email) {
    return repository
        .findUserEntityByEmailAndDeletedIsNull(email)
        .orElseThrow(
            () -> {
              log.error("User not found with provided email: {}", email);
              return new UserNotFoundException("");
            });
  }

  public UserEntity fetch(UUID id) {
    return repository
        .findByIdAndDeletedIsNull(id)
        .orElseThrow(
            () -> {
              log.error("User not found with provided id: {}", id);
              return new UserNotFoundException("");
            });
  }
}
