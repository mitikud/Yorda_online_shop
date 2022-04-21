package com.example.orderservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class ShoppingCart {

    String id;
    List<Product> products;
    double totalPrice;

}

