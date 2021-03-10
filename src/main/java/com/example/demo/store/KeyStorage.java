package com.example.demo.store;

import com.example.demo.models.Key;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component   //для чего нужно создавать отдельно СТОРЭДЖ и РЕПОЗИТОРИЙ???
public class KeyStorage { //класс для создания ключей и занесения их в Лист
    List<String> stringList = new ArrayList<>();

    public boolean keyExist(String key){ //метод для ПРОВЕРКИ НАХОЖДЕНИЯ ключа в листе ключей.
        return stringList.contains(key);
    }

    public void addKey(String key){ //метод для ДОБАВЛЕНИЯ ключа в лист.
        stringList.add(key);
    }

    public List<String> getAllKeys (){ //метод для ВЫВОДА/ПОКАЗА всех ключей из списка ключей
        return stringList;

    }

    //используется аргумент (String key) - потому что мы создаём метод , который отображает Ключ СТРОКОЙ в консоли, чтобы можно было его видеоть.

}
