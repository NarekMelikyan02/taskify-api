package com.example.taskifyapi.service;

import com.example.taskifyapi.entity.UserEntity;
import com.example.taskifyapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
}
