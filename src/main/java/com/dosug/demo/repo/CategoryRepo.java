package com.dosug.demo.repo;

import com.dosug.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepo extends JpaRepository<Category,UUID>{

    Category findFirstByTitle(String title);

    Category findCategoryByCategoryId(UUID uuid);
}
