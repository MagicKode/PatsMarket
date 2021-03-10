package com.example.demo.services;

import com.example.demo.Exceptions.PetNotFoundException;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.models.User;
import com.example.demo.store.KeyRepository;
import com.example.demo.store.KeyStorage;
import com.example.demo.store.UserRepository;
import com.example.demo.store.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static long userId = 1; //добавляем ID юзеру, чтобы при создании нового пользователя, вёлся счёт пользователя.


    List<User> userList;

    @Autowired
    UserRepository userRepository;

    @Autowired
    KeyStorage keyStorage;

    @Autowired
    KeyRepository keyRepository;


    public void addUser(User user){//создаём метод ДОБАВЛЕНИЯ пользователя в список.
        user.setId(userId);
        userList.add(user);
        userId++;
    }

    public User getUserById(long id){ //метод добавления юзера по ID
        for (User user:userList) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public void deleteUserById(long id){ //метод удаления юзера по ID
        if (getUserById(id)!= null){
            for (User user: userList){
                if (user.getId() == id){
                    userList.remove(user);
                    break;
                }
            }
        }else {
            throw new UserNotFoundException();
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
   }


    public boolean valid(String key){ //метод для проверки СОВПАДЕНИЯ ИСКОТОГО ключа и его НАЛИЧИЕ
        return keyStorage.keyExist(key);
    }




}
