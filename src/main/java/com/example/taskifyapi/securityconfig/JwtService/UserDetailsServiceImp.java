package com.example.taskifyapi.securityconfig.JwtService;

import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.repository.UserRepository;
import com.example.taskifyapi.securityconfig.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserDetailsServiceImp implements UserDetailsService {
  private final UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return userRepository.findUserEntityByEmail(username)
              .map(SecurityUser::new)
              .orElseThrow(()->new UsernameNotFoundException("Username not found"));
  }
}
