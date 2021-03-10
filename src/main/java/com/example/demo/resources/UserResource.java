package com.example.demo.resources;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserResource {  //почему мы не пишем данный класс?

    @Autowired // будем использовать данный класс и его методы, поэтому ИНЖЕКТИМ его сюда.
    UserService userService;

    @PostMapping(path = "/createWithArray") //аналог сервлетному запросу POST
    public ResponseEntity<String> createUserWithArray(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<String>("User is added",HttpStatus.OK);
    }

}
