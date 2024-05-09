package com.example.taskifyapi.service.security.JwtService;

import com.example.taskifyapi.repository.UserEntityRepository;
import com.example.taskifyapi.service.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserDetailsServiceImp implements UserDetailsService {

  private final UserEntityRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
        .findUserEntityByEmailAndDeletedIsNull(username)
        .map(SecurityUser::new)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
  }
}
