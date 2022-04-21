package com.example.orderservice.Controller;

import com.example.orderservice.Domain.Order;
import com.example.orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public Order addingNewOrder(@RequestBody Order order){
        return orderService.addNewOrder(order);
    }

    @GetMapping()
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById( @PathVariable String orderId){
        return orderService.getOrderById(orderId);
    }
}
