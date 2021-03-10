package com.example.demo.services;

import com.example.demo.Exceptions.PetNotFoundException;
import com.example.demo.models.Pet;
import com.example.demo.models.PetStatus;
import com.example.demo.store.PetRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service //для чего данная аннотация?
public class PetService { //

    @Autowired
    PetRepository petRepository;


    //private List<Pet> petList = new ArrayList<>(); //создаём лист СОХРАНЕНИЯ созданных зверей  //Для чего??? Если не использовать сторы. При наличии сторэджов , сейчас нет смысла создавать новый список.
    //private static long petId = 1;


    /*public void createPet(Pet pet){ //создаю метод СОЗДАНИЯ зверя
        pet.setId(petId);
        petList.add(pet);
        petId++;
    }*/


   /* public Pet getById(long id){ //создаю метод ДОСТАВАНИЯ зверя по ID
        for (Pet pet : petList) {
            if (pet.getId() == id){
                return pet;
            }
        }
        return null;   //Для чего нужен ВЕСЬ ЭТОТ МЕТОД ещё раз???? Просто для того, чтобы проверить наличие зверя.
    }*/

    /*public Pet getByPetStatus(PetStatus petStatus){ //создаём метод НАХОЖДЕНИЯ зверя по Статусу.
        for (Pet pet:petList){
            if (pet.getPetStatus()==petStatus) {
                return pet;
            }
        }
        return null;
    }*/


    /*public void updateExistPet(Pet pet){ //создаём метод ОБНОВЛЕНИЯ зверя, если изменился его статус.
        for (Pet currentPet : petList) {
            if (currentPet.getId() == pet.getId()) {
                petList.set(petList.indexOf(currentPet), pet);
            }else {
               throw new PetNotFoundException(pet.getId());// показываем исключение.
            }
        }
    }
*/


    /*public void deletePet(long id){//удаляем зверя по ID
        if (getById(id) != null){
            for (Pet currentPet: petList) {
                if (currentPet.getId() == id){
                    petList.remove(currentPet);
                    break;
                }
            }
        }else {
            throw new PetNotFoundException(id);  //вылетает исключение
        }
    }*/



    public void createPet(Pet pet){ //альтернативный метод СОЗДАНИЯ / ДОБАВЛЕНИЯ зверя в list
        petRepository.save(pet);
    }

    public Pet getByPetId(long id){ //альтернтивный метод НАХОЖДЕНИЯ зверя по ID
        return petRepository.getOne(id);
    }


    public List<Pet> getByPetStatus(PetStatus petStatus){//альтернативный метод НАХОЖЖЛДЕНИЯ зверя по Статусу.
        return petRepository.findAllByPetStatus(petStatus);
    }

    public void updateExistPet(Pet pet){//альтернативный метод ОБНОВЛЕНИЯ / СОХРАНЕНИЯ зверя
        petRepository.save(pet);
    }


    public void deleteByPetId(long id){//альтернативный метод УДАЛЕНИЯ зверя по ID
        petRepository.deleteById(id);
    }

    public List<Pet> petList(){//альтернативный метод НАХОЖДЕНИЯ ВСЕХ зверей в Листе
        return petRepository.findAll();
    }

}