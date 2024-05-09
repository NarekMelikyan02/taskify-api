package com.example.taskifyapi.dto.security;

import com.example.taskifyapi.enumeration.UserGender;
import com.example.taskifyapi.enumeration.UserRoles;

public record RegisterRequest(
    String firstName,
    String lastName,
    UserGender gender,
    String email,
    String password,
    UserRoles role) {}
