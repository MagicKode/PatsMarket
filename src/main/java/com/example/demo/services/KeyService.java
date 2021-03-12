package com.example.demo.services;

import com.example.demo.models.Key;
import com.example.demo.store.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyService {

    @Autowired
    KeyRepository keyRepository;


    public void addKey(Key key){//метод ДОБАВЛЕНИЯ ключа в репозиторий
        keyRepository.save(key);
    }

    public Key valid(Key key){ //метод ВАЛИДАЦИИ ключа
        return keyRepository.getKeyByKey(key.getKey());
    }

    public Key getKeyByKeyString(Key key){ //уточнить про этот метод??????
        return keyRepository.getKeyByKey(key.getKey());
    }

}
