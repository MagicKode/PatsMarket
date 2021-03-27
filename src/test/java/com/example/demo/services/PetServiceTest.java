package com.example.demo.services;

import com.example.demo.models.Category;
import com.example.demo.models.Pet;
import com.example.demo.models.Tag;
import com.example.demo.store.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest  //оработать Асёрты!!!
class PetServiceTest {

    @Autowired
    PetRepository petRepository;


    @Test
    void createPet() {
        Pet pet = new Pet();
        petRepository.save(pet);
        petRepository.getOne(2L);

    }

    @Test
    void getByPetId() {
        Pet pet = new Pet();
        petRepository.save(pet);
        petRepository.getOne(2L);
    }

    @Test
    void getByPetStatus() {
        Pet pet = new Pet();
        petRepository.save(pet);
        petRepository.getOne(1L);
    }

    @Test
    void updateExistPet() {
        Pet pet = new Pet();
        petRepository.save(pet);
        petRepository.getOne(1L);
    }

    @Test
    void deleteByPetId() {
        Pet pet = new Pet();
        petRepository.save(pet);
        petRepository.getOne(1L);
    }
}