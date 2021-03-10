package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data //для чего нужна данная аннотация???  //Говорит о том, что к полям нудно прикрутить GET, setter...дефолтно
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders") //ДЛя чего данная аннотация,,,

public class Order { //заказ и его характеристики

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long petId;
    private int quantiry;
    private LocalDate shipDate;
    private OrderStatus orderStatus;
    private boolean complete;
    private long userId;  //для чего здесь размещали UserId ????? Для того, чтобы можно было установить связь



    //Модель - это обычная мапа, где содержутся различные модели.

}
