package com.example.demo.resources;

import com.example.demo.models.Pet;
import com.example.demo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        @GetMapping(path = "/{id}")
                public ResponseEntity<Pet> findById(@PathVariable (name = "id")long id){
            Pet pet = petService.getById(id);
            return new ResponseEntity<>(pet,HttpStatus.OK);
        }
}
