package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity //для чего данная оннотация?? Позволяет идентифицировать
@Data
@Table(name = "keys")
public class Key {

    @Id //Для чего данная аннотация?? Для автоматической генерации ID при использовании его в других методах
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String key;
    UserStatus userStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key1 = (Key) o;
        return id == key1.id &&
                Objects.equals(key, key1.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key);
    }
}
