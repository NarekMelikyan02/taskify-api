package com.example.taskifyapi.service.security;

import com.example.taskifyapi.Dto.security.AuthenticationResponse;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.exeptions.EmailAlreadyExistsException;
import com.example.taskifyapi.repository.UserRepository;
import com.example.taskifyapi.security.JwtService.JwtService;
import com.example.taskifyapi.security.SecurityUser;
import java.time.LocalDateTime;
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

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  @Override
  @Transactional
  public AuthenticationResponse register(UserEntity request) {
    if (emailExists(request.getEmail())) {
      log.error("There is account with provided email: {}", request.getEmail());
      throw new EmailAlreadyExistsException("");
    } else {
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
  }

  @Override
  public AuthenticationResponse authenticate(UserEntity request) {
    SecurityUser secUser = new SecurityUser(request);
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(secUser.getUsername(), request.getPassword()));
    UserEntity user =
        userRepository.findUserEntityByEmailAndDeletedIsNull(secUser.getUsername()).orElseThrow();
    String token = jwtService.generateToken(new SecurityUser(user));
    return new AuthenticationResponse(token);
  }

  private boolean emailExists(String email) {
    return userRepository.findUserEntityByEmailAndDeletedIsNull(email).isPresent();
  }
}
