package com.example.taskifyapi.service.security;

import com.example.taskifyapi.dto.security.AuthenticationResponse;
import com.example.taskifyapi.dto.security.LoginRequest;
import com.example.taskifyapi.dto.security.RegisterRequest;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.exeptions.EmailAlreadyExistsException;
import com.example.taskifyapi.repository.UserEntityRepository;
import com.example.taskifyapi.security.JwtService.JwtService;
import com.example.taskifyapi.security.SecurityUser;
import java.time.LocalDateTime;

import com.example.taskifyapi.service.user.UserFetcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

  private final UserEntityRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserFetcher userFetcher;

  @Override
  @Transactional
  public AuthenticationResponse register(RegisterRequest request) {
    if (emailExists(request.email())) {
      log.error("There is account with provided email: {}", request.email());
      throw new EmailAlreadyExistsException("");
    } else {
      UserEntity user = new UserEntity();
      user.setFirstName(request.firstName());
      user.setLastName(request.lastName());
      user.setGender(request.gender());
      user.setEmail(request.email());
      user.setPassword(passwordEncoder.encode(request.password()));
      user.setRole(request.role());
      user.setCreated(LocalDateTime.now());
      userRepository.save(user);
      String token = jwtService.generateToken(new SecurityUser(user));
      return new AuthenticationResponse(token);
    }
  }

  @Override
  public AuthenticationResponse authenticate(LoginRequest request) {
    UserEntity user = userFetcher.fetch(request.email());
    SecurityUser secUser = new SecurityUser(user);
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(secUser.getUsername(), request.password()));
    String token = jwtService.generateToken(secUser);
    return new AuthenticationResponse(token);
  }

  private boolean emailExists(String email) {
    return userRepository.findUserEntityByEmailAndDeletedIsNull(email).isPresent();
  }
}
