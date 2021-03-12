package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet { //какой зверь (какие параметры запрашиваемого)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL) //ДЛя чего данная аннотация?? Для того, чтобы связать одну запись с одной
    private Category category; // у одного животного может быть только ОДНА категори (кот/собака и тд)
    private String name;

    @OneToMany(cascade = CascadeType.ALL) //ДЛя чего данная аннотация??
    private List<Tag>tags;  // к этому полю может быть применен ДОБАВЛНЕИЕ тэга много раз
    private PetStatus petStatus;





}
