package com.example.demo.services;

import com.example.demo.models.Order;
import com.example.demo.models.OrderStatus;
import com.example.demo.store.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    void addOrder() { //как правильно написать формат даты ShipDate??/
        Order order = new Order(1L,2L,3, LocalDate.now(), OrderStatus.DELIVERED,true,2L);
        orderRepository.save(order);
        orderRepository.getOne(1L);

    }

    @Test
    void getOrderById() {
        Order order = new Order(1L,2L,3,LocalDate.now(), OrderStatus.DELIVERED,true,2L);
        orderRepository.save(order);
        orderRepository.getOne(1L);
    }

    @Test
    void deleteOrderById() {
        Order order = new Order(1L,2L,3,LocalDate.now(), OrderStatus.DELIVERED,true,2L);
        orderRepository.save(order);
        orderRepository.getOne(1L);
    }

    @Test
    void getQuantityOfStatus() {
        Order order = new Order(1L,2L,3, LocalDate.now(), OrderStatus.DELIVERED,true,2L);
        orderRepository.save(order);
        orderRepository.getOne(1L);
    }
}
