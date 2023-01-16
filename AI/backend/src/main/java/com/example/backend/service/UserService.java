package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> register(UserDto userDto);

    Optional<User> findUserByUsername(String username);
}
