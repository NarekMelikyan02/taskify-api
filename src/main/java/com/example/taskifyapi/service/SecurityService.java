package com.example.taskifyapi.service;

import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.model.AuthenticationResponse;
import com.example.taskifyapi.repository.UserRepository;
import com.example.taskifyapi.securityconfig.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SecurityService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public SecurityService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(UserEntity request){
        UserEntity user=new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setCreated(LocalDateTime.now());
        userRepository.save(user);

        String token=jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(UserEntity request){
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                          request.getUsername(),
                          request.getPassword()
                    )
            );
            UserEntity user = userRepository.findByEmail(request.getUsername()).orElseThrow();
            String token =jwtService.generateToken(user);
            return new AuthenticationResponse(token);
    }
}
