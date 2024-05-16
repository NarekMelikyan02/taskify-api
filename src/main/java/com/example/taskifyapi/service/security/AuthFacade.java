package com.example.taskifyapi.service.security;

import com.example.taskifyapi.service.user.UserFetcher;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {
  private final UserFetcher fetcher;

  public String currentUserName() {
    return SecurityContextHolder.getContext().getAuthentication().getName();
  }

  public UUID currentUserId() {
    return fetcher.fetch(currentUserName()).getId();
  }
}
