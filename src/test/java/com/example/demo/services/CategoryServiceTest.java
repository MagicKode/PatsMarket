package com.example.demo.services;

import com.example.demo.models.Category;
import com.example.demo.store.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryServiceTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void addCategory() {
        Category category = new Category(1L,"test");
        categoryRepository.save(category);
        categoryRepository.getOne(2L);


    }

    @Test
    void getByCategoryId() {
        Category category = new Category(1L, "test");
        categoryRepository.save(category);
        categoryRepository.getOne(2L);
    }

    @Test
    void deleteCategoryById() {
        Category category = new Category(1L, "test");
        categoryRepository.save(category);
        categoryRepository.getOne(2L);
    }

    @Test
    void getAllCategories() {
        Category category = new Category(1L, "test");
        categoryRepository.save(category);
        categoryRepository.getOne(2L);
    }
}