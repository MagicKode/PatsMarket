package com.example.demo.services;

import com.example.demo.Exceptions.OrderNotFoundException;
import com.example.demo.models.Order;
import com.example.demo.models.Pet;
import com.example.demo.models.PetStatus;
import com.example.demo.store.OrderRepository;
import com.example.demo.store.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PetRepository petRepository;

   // private List<Order> orderList = new ArrayList<>(); //создаём лист ХРАНЕНИЯ заказов.
   // private static long orderId=1; //задаём начальное значение ID заказа, чтобы потом при добавлении получалось коненчое число заказов

   /* public void addOrder(Order order){ //создаём метод СОЗДАНИЯ/ДОБАВЛЕНИЯ заказа в лист.
        order.setId(orderId);
        orderList.add(order);
        orderId++;
    }
*/

   public void addOrder(Order order){//альтернативный метод ДОБАВЛЕНИЯ / СОХРАНЕНИЯ заказа в лист
       log.trace("Order is added");
       orderRepository.save(order);
   }

    /*public Order getOrderById(long id){ //создаём метод НАХОЖДЕНИЯ заказа по ID
        for (Order order : orderList) {
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    }*/

    public Optional<Order> getOrderById(long id){ //альтернативный метод НАХОЖДЕНИЯ заказа по ID
        return orderRepository.findById(id);
    }


    /*public boolean deleteOrderById(long id){ //создаём метод УДАЛЕНИЯ заказа из листа по ID
        for (Order order: orderList){
            if (order.getId() == id){
                orderList.remove(order);
                break;
            }
        }
        throw new OrderNotFoundException();
    }*/


    public boolean deleteOrderById(long id){ //альтернативный метод УДАЛЕНИЯ заказа по ID
        if (orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }


  /*  //для чего создаётся МАПА и как она работает подробно?? Мапа нужна для того, чтобы выводить в результате

    public Map<PetStatus,Integer> getQuantityOfStatus(){ //метод должен возвращать Статус и его НОМЕР.
        Map<PetStatus, Integer> statusList = new HashMap<>(); // как объект, внутри которого будут складываться наши статусы и их номера.
        List<Pet>petList = petService.getByPetStatus(); //мы достаём из репозитория зверей с их параметрами, и далее передаем в мапу через
        int availableCounter = 0;
        int pendingCounter = 0;
        int soldCounter = 0;
        for (Pet currentPet : petList) {
            switch (currentPet.getPetStatus()){
                case SOLD:
                    soldCounter++;
                    break;
                case PENDING:
                    pendingCounter++;
                    break;
                case AVAILABLE:
                    availableCounter++;
                    break;
                    default: return null;
            }
        }
        statusList.put(SOLD,soldCounter);
        statusList.put(AVAILABLE, availableCounter);
        statusList.put(PENDING, pendingCounter);
                return statusList;

    }*/

  public Map<PetStatus,Integer> getQuantityOfStatus(List<Pet> petList){ //альтернативный компактный метод. метод позволяет подсчитать и рассортировать статусы.
      Map<PetStatus, Integer> statusList = new HashMap<>();
      for (Pet currentPet : petList){
          statusList.put(currentPet.getPetStatus(),statusList.getOrDefault(currentPet.getPetStatus(),0)+1); //
      }
      return statusList;
  }
}
