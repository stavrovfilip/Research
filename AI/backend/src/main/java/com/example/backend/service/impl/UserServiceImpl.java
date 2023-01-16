package com.example.backend.service.impl;

import com.example.backend.model.User;
import com.example.backend.model.dto.UserDto;
import com.example.backend.model.exceptions.UserException;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> register(UserDto userDto) {
        if (userDto.getUsername() == null || userDto.getUsername().isEmpty())
            throw new UserException();

        if (userDto.getPassword() == null || userDto.getPassword().isEmpty())
            throw new UserException();

        if (this.userRepository.findById(userDto.getUsername()).isPresent()) {
            throw new UserException();
        }

        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            throw new UserException();
        }

        return Optional.of(userRepository.save(new User(userDto.getUsername(),
                userDto.getName(),
                userDto.getLastName(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getRole())));
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return this.userRepository.findById(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  this.userRepository.findById(username).orElseThrow(UserException::new);
    }
}
