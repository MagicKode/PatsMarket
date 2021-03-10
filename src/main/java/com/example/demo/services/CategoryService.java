package com.example.demo.services;

import com.example.demo.models.Category;
import com.example.demo.store.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {  //ПОЧЕМУ МЫ РАБОТАЕМ С КАТЕГОРИЯМИ, ДЛЯ ЧЕГО???

    @Autowired
    CategoryRepository categoryStorage;

    public void addCategory(Category category){ //метод ДОБАВЛЕНИЯ категории
        categoryStorage.save(category);
    }

    public Category getByCategoryId(long id){ //метод ДОСТАТЬ каьегорию по ID
        return categoryStorage.getOne(id);
    }

    public void deleteCategoryById(long id){ //метод УДАЛЕНИЯ категориипо ID
        categoryStorage.deleteById(id);
    }

    public List<Category> getAllCategories(){// метод ДОСТАТЬ ВСЕ категории из списка.
        return categoryStorage.findAll();
    }

}
