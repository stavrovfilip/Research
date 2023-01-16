package com.example.backend.service;

import com.example.backend.model.Research;
import com.example.backend.model.dto.CreateResearchDto;
import com.example.backend.model.dto.EditResearchDto;

import java.util.List;
import java.util.Optional;

public interface ResearchService {
    List<Research> findAll();
    List<Research> findByUser(String username);
    List<Research> findByCategory(Long categoryId);
    List<Research> findByTitle(String title);
    Optional<Research> findById(Long id);
    Research create(CreateResearchDto createResearchDto);
    Research edit(EditResearchDto editResearchDto);
    void delete(Long id);
}
