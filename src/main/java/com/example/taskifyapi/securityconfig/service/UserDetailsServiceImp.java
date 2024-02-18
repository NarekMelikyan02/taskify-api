package com.example.taskifyapi.securityconfig.service;

import com.example.taskifyapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository repository;

    public UserDetailsServiceImp(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(
                ()->new UsernameNotFoundException("User is not found")
        );
    }
}
