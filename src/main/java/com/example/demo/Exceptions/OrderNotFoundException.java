package com.example.demo.Exceptions;


public class OrderNotFoundException extends RuntimeException{ //для чего класс наследуется от Данного исключения???             Для того, чтобы мы не заморачивались с проверкой данного исключения.


    public OrderNotFoundException() {
        super();
    }

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderNotFoundException(Throwable cause) {
        super(cause);
    }
}

        //для чего данные методы ???? Для того, чтобы пробрасывать на уровень, Это нужно делать.