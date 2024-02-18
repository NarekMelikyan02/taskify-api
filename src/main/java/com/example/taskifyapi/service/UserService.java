package com.example.taskifyapi.service;

import com.example.taskifyapi.Dto.UserDto;
import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::userMapper)
                .collect(Collectors.toList());
    }

    private UserDto userMapper(UserEntity user) {
        return UserDto.builder()
                .Id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .gender(user.getGender())
                .asignedTasks(user.getAsignedTasks())
                .build();
    }

    public UserDto getById(UUID id) {
        return userMapper(userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found by provided id" + id)));
    }
}
