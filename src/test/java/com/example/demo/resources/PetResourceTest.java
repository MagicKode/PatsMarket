package com.example.demo.resources;

import com.example.demo.models.Pet;
import com.example.demo.store.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PetResourceTest {

    @Autowired
    PetRepository petRepository;


 /*   @Test
    void createPet() {
        Pet pet = new Pet(1,"test","test","");
        petRepository.
    }

    @Test
    void findById() {
    }

    @Test
    void getByPetStatus() {
    }

    @Test
    void updatePet() {
    }

    @Test
    void deletePet() {
    }*/
}