package com.example.shoppingcartservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String orderId;
    private ShoppingCart shoppingCart;
    private Customer customer;
}
