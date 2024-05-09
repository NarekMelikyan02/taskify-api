package com.example.taskifyapi.config;

import com.example.taskifyapi.service.security.JwtService.UserDetailsServiceImp;
import com.example.taskifyapi.service.security.filter.JwtAuthenticationFilter;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final UserDetailsServiceImp userDetailsServiceImp;
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(@Nonnull HttpSecurity http) throws Exception {

    return http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            req ->
                req.requestMatchers(
                        "/Authentication/login/**", "/Authentication/register/**", "/Mar/Jan/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .userDetailsService(userDetailsServiceImp)
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
      throws Exception {
    return configuration.getAuthenticationManager();
  }
}
