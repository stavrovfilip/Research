package com.example.backend.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateResearchDto {
    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Long categoryId;

    @NotNull
    private String username;

    public CreateResearchDto(String title, String description, Long categoryId, String username) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.username = username;
    }
}
