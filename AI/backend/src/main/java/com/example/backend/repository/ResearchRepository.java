package com.example.backend.repository;

import com.example.backend.model.Category;
import com.example.backend.model.Research;
import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ResearchRepository extends JpaRepository<Research, Long>{
    List<Research> findResearchesByUser(User user);

    List<Research> findResearchesByCategory(Category category);

    List<Research> findResearchesByTitleLike(String title);

    List<Research> findResearchesByTitle(String title);
}
