package com.example.demo.Exceptions;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(long id) {
        super("Pet with ID = "+id+" is not found.");
    }
}
