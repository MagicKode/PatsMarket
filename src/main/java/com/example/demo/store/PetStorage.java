package com.example.demo.store;

import com.example.demo.models.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetStorage {

    private List<Pet> petList = new ArrayList<>(); //создаём лист ХРАНЕНИЯ зверей


    public boolean add(Pet pet){ //создаём метод ДОБАВЛЕНИЯ зверя в лист.
        if (petList.contains(pet)){
            return false;
        }
        petList.add(pet);
        return true;
    }

    //что из себя представляет метод ОБНОВЛЕНИЯ списка зверей???? Тут ипользуется просто equals.



    public Pet getByPetId(long id){ //  метод ВЫБОРКИ зверя по ID.

        for (Pet pet: petList){
            if (pet.getId()==id){
                return pet;
            }
        }
        return null;
    }


    public boolean deleteByPetId(long id){ //метод УДАЛЕНИЯ зверя из листа по ID

        for (Pet pet: petList){
            if (pet.getId()==id){
                petList.remove(pet);
                return true;
            }
        }
        return false;
    }

//остальные методы нахождения зваеря по СТАТУСУ пишутся в директории Service.


}
