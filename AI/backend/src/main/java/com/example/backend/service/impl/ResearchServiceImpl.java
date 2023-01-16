package com.example.backend.service.impl;

import com.example.backend.model.Category;
import com.example.backend.model.Research;
import com.example.backend.model.User;
import com.example.backend.model.dto.CreateResearchDto;
import com.example.backend.model.dto.EditResearchDto;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.ResearchRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.ResearchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchServiceImpl implements ResearchService {

    private final ResearchRepository researchRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public ResearchServiceImpl(ResearchRepository researchRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.researchRepository = researchRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Research> findAll() {
        return this.researchRepository.findAll();
    }

    @Override
    public List<Research> findByUser(String username) {
        User user = this.userRepository.findById(username).orElseThrow();

        return this.researchRepository.findResearchesByUser(user);
    }

    @Override
    public List<Research> findByCategory(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow();

        return this.researchRepository.findResearchesByCategory(category);
    }

    @Override
    public List<Research> findByTitle(String title) {
        return this.researchRepository.findResearchesByTitle(title);
    }

    @Override
    public Optional<Research> findById(Long id) {
        return this.researchRepository.findById(id);
    }

    @Override
    public Research create(CreateResearchDto createResearchDto) {
        Category category = this.categoryRepository.findById(createResearchDto.getCategoryId()).orElseThrow();
        User user = this.userRepository.findById(createResearchDto.getUsername()).orElseThrow();

        Research research = new Research(createResearchDto.getTitle(), createResearchDto.getDescription(),
                category, user);

        return this.researchRepository.save(research);

    }

    @Override
    public Research edit(EditResearchDto editResearchDto) {
        Research research = this.researchRepository.findById(editResearchDto.getId()).orElseThrow();
        Category category = this.categoryRepository.findById(editResearchDto.getCategoryId()).orElseThrow();

        research.setTitle(editResearchDto.getTitle());
        research.setDescription(editResearchDto.getDescription());
        research.setCategory(category);

        return this.researchRepository.save(research);
    }

    @Override
    public void delete(Long id) {
        this.researchRepository.deleteById(id);
    }
}
