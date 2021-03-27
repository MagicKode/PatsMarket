package com.example.demo.store;

import com.example.demo.models.Tag;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface TagRepository extends JpaRepository<Tag, Long> {
}
