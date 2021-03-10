package com.example.demo.store;

import com.example.demo.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //для чего нужна данная аннотация???? Для того, чтобы более детально обратно.
public class OrderStorage {

    private List<Order> orderList = new ArrayList<>(); //создаю СПИСОК хранения Заказов.

    public boolean add(Order order){ //создаём метод ДОБАВЛЕНИЯ заказа в Лист
        if (orderList.contains(order)){
            return false;
        }else {
            orderList.add(order);
            return true;
        }
    }


    public Order getById(long id){ // создаю метод НАХОЖДЕНИЯ заказа по ID.
        for (Order order:orderList) {
            if (order.getId()==id){
                return order;
            }
        }
        return null;
    }


    public boolean deleteById(long id){ // создаём метод УДАЛЕНИЯ заказа по ID.
        for (Order order:orderList){
            if (order.getId()==id){
                orderList.remove(order);
                return true;
            }
        }
        return false;
    }


    public List<Order> getOrders(){ // Для чего нужен этот метод?????
        return new ArrayList<>(orderList);
    }

}
