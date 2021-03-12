package com.example.demo.store;

import com.example.demo.models.Key;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends JpaRepository <Key, Long> {  //уточнить про дополнительные методы????

    boolean findByKey(String key);
    Key getKeyByKey(String key);
}
