package com.example.demo.services;

import com.example.demo.Exceptions.PetNotFoundException;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.models.Key;
import com.example.demo.models.User;
import com.example.demo.store.KeyRepository;
import com.example.demo.store.KeyStorage;
import com.example.demo.store.UserRepository;
import com.example.demo.store.UserStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.awt.font.ShapeGraphicAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private static long userId = 1; //добавляем ID юзеру, чтобы при создании нового пользователя, вёлся счёт пользователя.


    List<User> userList;

    @Autowired
    UserRepository userRepository;

    @Autowired
    KeyStorage keyStorage;

    @Autowired
    KeyRepository keyRepository;

    //Пишем методы действия с Юзерами
    public void addUser(User user){ //альтернативный метод ДОБАВЛЕНИЯ / СОЗДАНИЯ  нового Юзера.
        log.info("user is created");
        userRepository.save(user);
    }

    public Optional <User> getUserById(long id){//альтернативный метод НАХЛЖДЕНИЯ юзера по ID
        return userRepository.findById(id);
    }

    public void deleteUserById(long id){// альтернативный метод УДАЛЕНИЯ юзера по ID
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public boolean valid(String key){ //метод для проверки СОВПАДЕНИЯ ИСКОТОГО ключа и его НАЛИЧИЕ
        return keyStorage.keyExist(key);
    }

    public void addKey(String key){//альтернативный метод для ДОБАВЛЕНИЯ ключей
        keyStorage.addKey(key);
    }

    public String getKeyByKey(String s){//для чего данный метод?????
        List<String> keyList = keyStorage.getAllKeys();

        for (String key:keyList) {
            if (key.equals(s)){
                return key;
            }
        }
        return "no SUCH key exists";
    }
}





    /*public void addUser(User user){//создаём метод ДОБАВЛЕНИЯ пользователя в список.
        user.setId(userId);
        userList.add(user);
        userId++;
    }
*/

   /* public User getUserById(long id){ //метод добавления юзера по ID
        for (User user:userList) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }*/

    /*public void deleteUserById(long id){ //метод удаления юзера по ID
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
    }*/

