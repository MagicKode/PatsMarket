package com.example.demo.resources;

import com.example.demo.Exceptions.PetNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler { //для чего предназначен данный класс????


    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<Object> petNotFoundHandler (PetNotFoundException ex){// метод для обработки исключения, при вызове которого выводится соответствующее сообщение.
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
