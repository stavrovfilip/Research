package com.example.backend.web.rest;

import com.example.backend.model.Research;
import com.example.backend.model.dto.CreateResearchDto;
import com.example.backend.model.dto.EditResearchDto;
import com.example.backend.service.ResearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/researches")
@CrossOrigin("http://localhost:8080")
public class ResearchResource {

    private final ResearchService researchService;

    public ResearchResource(ResearchService researchService) {
        this.researchService = researchService;
    }

    @GetMapping
    public List<Research> ListAllResearches() {
        return this.researchService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Research> findResearchById(@PathVariable Long id) {
        return this.researchService.findById(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Optional<Research> addResearch(@RequestParam String title,
                                @RequestParam String description,
                                @RequestParam Long categoryId,
                                @RequestParam String username) throws JsonProcessingException {

        CreateResearchDto createResearchDto = new CreateResearchDto(title, description, categoryId, username);

        return Optional.of(this.researchService.create(createResearchDto));
    }

    @PostMapping("/edit")
    public Optional<Research> editResearch(@RequestBody EditResearchDto editResearchDto) {
        return Optional.of(this.researchService.edit(editResearchDto));
    }

    @DeleteMapping("delete/{id}")
    public void deleteResearch(@PathVariable Long id) {
        this.researchService.delete(id);
    }

}
