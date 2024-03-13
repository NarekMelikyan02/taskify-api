package com.example.taskifyapi.service;

import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.exeptions.UserNotFoundException;
import com.example.taskifyapi.model.AuthenticationResponse;
import com.example.taskifyapi.repository.UserRepository;
import com.example.taskifyapi.securityconfig.JwtService.JwtService;
import com.example.taskifyapi.securityconfig.SecurityUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(UserEntity request) {
    UserEntity user = new UserEntity();
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setGender(request.getGender());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole(request.getRole());
    user.setCreated(LocalDateTime.now());
    userRepository.save(user);
    String token = jwtService.generateToken(new SecurityUser(user));
    return new AuthenticationResponse(token);
  }

  public AuthenticationResponse authenticate(UserEntity request) {
      SecurityUser secUser=new SecurityUser(request);
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(secUser.getUsername(), request.getPassword()));
    UserEntity user = userRepository.findUserEntityByEmail(secUser.getUsername()).orElseThrow();
    String token = jwtService.generateToken(new SecurityUser(user));
    return new AuthenticationResponse(token);
  }

  public void updateUser(final UserEntity request, final UUID id) {
    UserEntity user =
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setGender(request.getGender());
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());
    user.setUpdated(LocalDateTime.now());
    log.info("Successfully updated user by id: {}", request.getId());
    userRepository.save(user);
  }
}
