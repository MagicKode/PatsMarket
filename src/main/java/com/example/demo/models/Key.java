package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //для чего данная оннотация?? Позволяет
@Data
public class Key {

    @Id //Для чего данная аннотация??
    long id;
    String key;
}
