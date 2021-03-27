package com.example.demo.resources;

import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
@Slf4j
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @PostMapping(path = "")
    public ResponseEntity<String> createCategory(@RequestBody Category category){ //метод добавления категории
        log.info("Category is created.");
        categoryService.addCategory(category);
        return new ResponseEntity<>("Category is created", HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(name = "id")long id){ //метод ЗАПРОСА ДОСТАТЬ категорию оп ID
        log.info("Category with id= "+id+" was found");
        return new ResponseEntity<>(categoryService.getByCategoryId(id),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable(name = "id") long id){// метод УДАЛЕНИЯ категории ПРИ ЗАПРОСЕ.
        log.info("Category with id= "+id+" is deleted!");
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>("Category"+categoryService.getByCategoryId(id).getName()+" is deleted",HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Category>> getAllCategories(){ //метод для ОТОБРАЖЕНИЯ ВСЕХ категорий при ЗАПРОСЕ
        log.info("AllCategories were deleted!!");
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }


}
