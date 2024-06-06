package com.example.taskifyapi.service.user;

import com.example.taskifyapi.dto.user.UserDto;
import com.example.taskifyapi.dto.user.UserRequest;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.repository.UserEntityRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
  private final PasswordEncoder encoder;
  private final UserEntityRepository userRepository;
  private final UserFetcher userFetcher;

  @Override
  public UserDto updateUser(UserRequest request, final UUID id) {
    UserEntity user = userFetcher.fetch(id);
    user.setFirstName(request.firstName());
    user.setLastName(request.lastName());
    user.setGender(request.gender());
    user.setEmail(request.email());
    user.setPassword(encoder.encode(request.password()));
    user.setUpdated(LocalDateTime.now());
    log.info("Successfully updated user by id: {}", user.getId());
    user = userRepository.save(user);
    return UserMapper.map(user);
  }

  @Override
  public List<UserDto> getAll() {
    return userRepository.getAllByDeletedIsNull().stream().map(UserMapper::map).toList();
  }

  @Override
  public UserDto getById(UUID id) {
    UserEntity user = userFetcher.fetch(id);
    return UserMapper.map(user);
  }

  @Override
  public void deleteById(final UUID userId) {
    UserEntity user = userFetcher.fetch(userId);
    user.setAssignedTasks(null);
    user.setDeleted(LocalDateTime.now());
    userRepository.save(user);
    log.info("Successfully deleted user: {}", userId);
  }
}
