//package com.example.shoppingcartservice.Service;
//
//import com.example.shoppingcartservice.Domain.ShoppingCart;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ShoppingCartSender {
//    @Autowired
//    private KafkaTemplate<String, ShoppingCart> kafkaTemplate;
//
//    private String topic="placeOrder";
//
//    public void checkOut(ShoppingCart shoppingCart){
//        System.out.println("now sending to order microservice");
//        kafkaTemplate.send(topic, shoppingCart);
//        System.out.println("CONGRATULATIONS ITEM IS SENT TO TOPIC");
//    }
//}
