package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.models.UserStatus;
import com.example.demo.store.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test // пишем Тест на ДОБАВЛЕНИЕ юзера
    void addUser() {
        User user = new User(5,"test","test","test","abcd@mail.com","12345","54321", UserStatus.ADMIN);
        userRepository.save(user);
        userRepository.getOne(2L);


    }

    @Test //тест на НАХОЖДЕНИЕ юзера по ID
    void getUserById() {
        User user = new User(5,"test","test","test","abcd@mail.com","12345","54321", UserStatus.ADMIN);
        userRepository.save(user);
        userRepository.getOne(2L);

    }

    @Test //тест на УДАЛЕНИЕ юзера по ID
    void deleteUserById() {
        User user = new User(5,"test","test","test","abcd@mail.com","12345","54321", UserStatus.ADMIN);
        userRepository.save(user);
        userRepository.getOne(2L);
    }
}

//ассёрты - проверя.т наличие чего-либо. Это точки, в которых мы можем проверить инфу на определённое условие.