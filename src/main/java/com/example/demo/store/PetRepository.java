package com.example.demo.store;

import com.example.demo.models.Pet;
import com.example.demo.models.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet>findAllByPetStatus(PetStatus petStatus);
}
