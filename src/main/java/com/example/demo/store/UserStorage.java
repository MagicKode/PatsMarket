package com.example.demo.store;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserStorage {

    private List<User> userList = new ArrayList<>(); //создаём ЛИСТ для хранения пользователей.


    public boolean add(User user){  //создаю медот ДОБАВЛЕНИЯ юзера в лист
        if (userList.contains(user)){
            return false;
        }
        userList.add(user);
        return true;
    }


    public User getByUserName(String userName){ //создаём метод НАХОЖДЕНИЯ и ДОСТАВАНИЯ юзера по ИМЕНИ
        for (User user:userList){
            if (user.getUserName().equals(userName)){
                return user;
            }
        }
        return null; // это избыточный код
    }

    public boolean deleteByUserName(String userName){  //создаём метод УДАЛЕНИЯ юзера из списка по Имени.
        for (int i = 0; i < userList.size() ; i++) {  //будет ли аналогия перебора юзеров в списке по очереди также                                                                                                 эфективна как цикл For????
            if (userList.get(i).getUserName().equals(userName)){
                userList.remove(i);
                return true;
            }
        }
        return false;
    }


    //Пробный метод перебора юзеров по очереди в списке!!

    /*public boolean deleteByUserName(String userName){
        for (User user:userList) {
            if (userList.getUserName().equals(userName)){
                userList.remove(user);
                return true;
            }
        }
        return false;
    }*/


    //методы регистрация юзера Логина, в систему пищем в другом репозитории...??

}
