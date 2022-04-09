package com.yordaonline.shoppingCart.Domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@Document
public class Product {

    @Id
    private String productNumber;
    private String name;
    private double price;
    private String description;
    private int quantity;
//    private boolean productStatus;
}
