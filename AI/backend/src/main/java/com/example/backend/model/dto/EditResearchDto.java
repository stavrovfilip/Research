package com.example.backend.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EditResearchDto {

    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Long categoryId;

    public EditResearchDto(Long id, String title, String description, Long categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }
}
