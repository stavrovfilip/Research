package com.example.backend.service;

import com.example.backend.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    List<Category> findCategoriesByText(String text);
}
