package com.example.backend.model.dto;

import com.example.backend.model.enums.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull
    private String username;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @NotNull
    private String repeatPassword;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Role role;


    public UserDto(String username,
                   String name,
                   String lastName,
                   String password,
                   String repeatPassword,
                   Role role) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.role = role;
    }
}
