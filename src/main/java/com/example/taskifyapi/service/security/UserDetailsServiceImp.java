package com.example.taskifyapi.service.security;

import com.example.taskifyapi.service.user.UserFetcher;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserDetailsServiceImp implements UserDetailsService {

  private final UserFetcher userFetcher;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new SecurityUser(userFetcher.fetch(username));
  }
}
