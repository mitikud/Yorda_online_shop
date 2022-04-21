package com.example.orderservice.Service;

import com.example.orderservice.Domain.Order;
import com.example.orderservice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order addNewOrder(Order order){
        return orderRepository.save(order);
    }

    public Order getOrderById(String orderId){
       return orderRepository.findById(orderId).get();
    }

    public List<Order> getAllOrders(){
        return  orderRepository.findAll();
    }
}
