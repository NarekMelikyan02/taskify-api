package com.example.taskifyapi.dto.user;

import com.example.taskifyapi.enumeration.user.UserGender;

public record UserRequest(
    String firstName, String lastName, UserGender gender, String email, String password) {}
