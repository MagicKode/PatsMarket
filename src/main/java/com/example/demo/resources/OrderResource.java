package com.example.demo.resources;

import com.example.demo.models.Order;
import com.example.demo.models.Pet;
import com.example.demo.models.PetStatus;
import com.example.demo.models.User;
import com.example.demo.services.OrderService;
import com.example.demo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController //аннотация для улучшенного диалога клиент-модель.
@RequestMapping(path = "/store")//приходящий запрос на этот адрес этого контроллера.
public class OrderResource { //для чего данный класс?? для того, чтобы происходило взаимодействие между методами и моделями.

    @Autowired
    OrderService orderService;
    @Autowired
    PetService petService; //мы их просто сюды инжектим, чтобы исопльзовать.

    @PostMapping(path = "/oerder") //метод для добавления заказа , при его запросе.
    public ResponseEntity<String> createOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return new ResponseEntity<>("Order is created", HttpStatus.CREATED);
    }

    @GetMapping (path = "/order/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") long orderId){
        Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @DeleteMapping (path = "/order/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable ("orderId") long orderId){
        if (orderService.deleteOrderById(orderId)){
            return new ResponseEntity<>("Order delete", HttpStatus.OK);
        }else {
          return new ResponseEntity<>("Order is not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/inventory")
    public ResponseEntity<Map<PetStatus,Integer>> getStatusList(){
        Map<PetStatus,Integer> quantityStatus = orderService.getQuantityOfStatus();
        return new ResponseEntity<>(quantityStatus,HttpStatus.OK);
    }
}
