package com.example.demo.store;

import com.example.demo.models.Category;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class CategoryStore {

    private List<Category> categoryList = new ArrayList<>();

    public boolean addCategory(Category category){ // метод по ДОБАВЛЕНИЮ категории.
        return categoryList.add(category);
    }

    public Category getCategoryById(long id){ //метод по НАХОЖДЕНИЮ категории по ID
        for (Category category : categoryList) {
            if (category.getId()==id){
                return category;
            }
        }
        return  null;
    }

    public void deleteCategoryById(long id){ //метод по УДАЛЕНИЮ категории по ID
        for (Category category:categoryList){
            if (category.getId()==id){
                categoryList.remove(category);
            }
        }
    }
}
