package com.example.taskifyapi.dto.security;

import com.example.taskifyapi.entity.enums.UserGender;
import com.example.taskifyapi.entity.enums.UserRoles;

public record RegisterRequest(
    String firstName,
    String lastName,
    UserGender gender,
    String email,
    String password,
    UserRoles role) {}
