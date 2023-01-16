package com.example.backend.config;

import com.example.backend.model.User;
import com.example.backend.model.dto.UserDto;
import com.example.backend.model.enums.Role;
import com.example.backend.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class DataInitializer {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initAdmins() {
        Optional<User> user1 = userService.findUserByUsername("filip");
        if (user1.isEmpty()) {
            UserDto userDto1 = new UserDto("filip",
                    "Filip",
                    "Stavrov",
                    "filip",
                    "filip",
                    Role.ADMIN);
            this.userService.register(userDto1);
        }
    }
}