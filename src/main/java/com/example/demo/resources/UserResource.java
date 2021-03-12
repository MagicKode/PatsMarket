package com.example.demo.resources;

import com.example.demo.models.Key;
import com.example.demo.models.User;
import com.example.demo.services.KeyService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserResource {  //почему мы не пишем данный класс?

    @Autowired // будем использовать данный класс и его методы, поэтому ИНЖЕКТИМ его сюда.
    UserService userService;

    @Autowired
    KeyService keyService;


    @PostMapping(path = "/createWithArray") //аналог сервлетному запросу POST
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<String>("User is added",HttpStatus.OK);
    }

   /* @PostMapping(path = "/auth") //Уточнить по пофоду прописания путя в скобках??? //шаблон запроса на АВТОРИЗАЦИЮ юзера
    public ResponseEntity<String> authorization(@RequestBody User user) {
        if (userService.getUserById(user.getId()) != null) {
            UUID uuid = UUID.randomUUID(); //универсальный ID
            String s = uuid.toString(); // прописывае , чтобы отображался универсальный ключ ввиде строки.
            userService.addKey(s);

            return new ResponseEntity<>(userService.getKeyByKey(s), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    @GetMapping(path = "/{id}")
    public ResponseEntity<User>getUserByID(@PathVariable(name = "id")long id){
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/getKey")  //ОБЪЯСНИТЬ ВЕСЬ МЕТОД!!!!????? Почему он заменяет авторизацию??
    public ResponseEntity<Key> getKey(@RequestBody User user){
        if (userService.getUserById(user.getId()).isPresent()){
            UUID uuid = UUID.randomUUID();
            Key key = new Key();
            key.setKey(uuid.toString());
            key.setUserStatus(user.getUserStatus());
            keyService.addKey(key);
            Key keyByKeystring = keyService.getKeyByKeyString(key);
            return new ResponseEntity<>(keyByKeystring, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
