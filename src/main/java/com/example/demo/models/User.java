package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;


    public boolean equals(Object o){//Для чего нужен данный метод?? чтобы при сравнении Юзеров между собой, он сравнивал именно те поля, которые мы укказываем
        if (this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password)&&
        userStatus == user.userStatus;
    }

    @Override
    public int hashCode(){// позволяет отличать Юзеров в базе
        return Objects.hash(userName, password, userStatus);
    }
}
