package com.example.taskifyapi.dto.security;

import com.example.taskifyapi.enumeration.user.UserGender;
import com.example.taskifyapi.enumeration.user.UserRoles;

public record RegisterRequest(
    String firstName,
    String lastName,
    UserGender gender,
    String email,
    String password,
    UserRoles role) {}
