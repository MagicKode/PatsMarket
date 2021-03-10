package com.example.demo.Exceptions;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(long id) {
        super();
    }

    public PetNotFoundException(String message) {
        super(message);
    }

    public PetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetNotFoundException(Throwable cause) {
        super(cause);
    }
}
