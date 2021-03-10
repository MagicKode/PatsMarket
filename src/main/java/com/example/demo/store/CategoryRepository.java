package com.example.demo.store;

import com.example.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //почему вместо классов у нас стали ИНТЕРФЕЙСЫ???
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
