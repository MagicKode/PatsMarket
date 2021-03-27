package com.example.demo.services;

import com.example.demo.models.Category;
import com.example.demo.store.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {  //ПОЧЕМУ МЫ РАБОТАЕМ С КАТЕГОРИЯМИ, ДЛЯ ЧЕГО???

    @Autowired
    CategoryRepository categoryStorage;

    public void addCategory(Category category){ //метод ДОБАВЛЕНИЯ категории
        log.info("Category "+category+" was added");
        categoryStorage.save(category);
    }

    public Category getByCategoryId(long id){ //метод ДОСТАТЬ каьегорию по ID
        log.info("Category with id= "+id+" was found");
        return categoryStorage.getOne(id);
    }

    public void deleteCategoryById(long id){ //метод УДАЛЕНИЯ категориипо ID
        log.info("Category with id= "+id+" was deleted!");
        categoryStorage.deleteById(id);
    }

    public List<Category> getAllCategories(){// метод ДОСТАТЬ ВСЕ категории из списка.
        log.info("All Categories were found!!");
        return categoryStorage.findAll();
    }

}
