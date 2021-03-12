package com.example.demo.resources;

import com.example.demo.models.Pet;
import com.example.demo.models.PetStatus;
import com.example.demo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping(path = "/pet") //аннотация ищет файлы , если вписать и его порт
public class PetResource {

    @Autowired
    private PetService petService;

    @PostMapping //это аналоги doGet doPost
    public ResponseEntity<String> createPet(@RequestBody Pet pet){ //Это шаблон запроса, котоый должен быть передан. А класс возвращает Шаблонированный ответ PET.Для этого и пишется аннотация в скобках
        petService.createPet(pet);
        return new ResponseEntity<>("Pet" + pet.getName()+" created", HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")// шаблон запроса по НАХОЖДЕНИЮ зверя по ID.
    public ResponseEntity<Pet> findById(@PathVariable (name = "id")long id){
        Pet pet = petService.getByPetId(id);
        return new ResponseEntity<>(pet,HttpStatus.OK);
        }

    @GetMapping(path = "/{PetStatus}") //шаблог запроса по НАХОЖДЕНИЯ зверя по Статусу
    public ResponseEntity<List<Pet>> getByPetStatus(@PathVariable (name = "petStatus")PetStatus petStatus){
        List<Pet> petList = petService.getByPetStatus(petStatus);
        return new ResponseEntity<>(petList, HttpStatus.OK);
    }

    @PostMapping(path = "/{newPet}")// шаблон запроса на ОБНОВЛЕНИЕ зверя
    public ResponseEntity<String> updatePet(@PathVariable (name = "newPet") Pet pet){
        petService.updateExistPet(pet);
        return new ResponseEntity<>("Pet " + pet.getName() + " updated", HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}") //шаблон запроса на УДАЛЕНИЕ зверя по ID
    public ResponseEntity<String> deletePet(@PathVariable(name = "id")long id){
        petService.deleteByPetId(id);
        return new ResponseEntity<>("Pet "+petService.getByPetId(id).getName()+" deleted",HttpStatus.OK);
    }
}
