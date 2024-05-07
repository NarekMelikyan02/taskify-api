package com.example.taskifyapi.dto.requests.user;

import com.example.taskifyapi.entity.enums.UserGender;

public record UserRequest(
    String firstName, String lastName, UserGender gender, String email, String password) {}
