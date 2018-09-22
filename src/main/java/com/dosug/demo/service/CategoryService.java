package com.dosug.demo.service;

import com.dosug.demo.model.Category;
import com.dosug.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category findCategoryById(UUID uuid) {
        return categoryRepo.findCategoryByCategoryId(uuid);
    }

    public Category findByTitleCategory(String title) {
        return categoryRepo.findFirstByTitle(title);
    }

    public void save(Category category) {
        categoryRepo.save(category);
    }
}
