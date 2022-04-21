package com.example.shoppingcartservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productId;
    private String productName;
    private String categoryName;
    private String description;
    private double unitPrice;
    private Integer quantity;
    private String vendorId;
    private boolean status;
//    private String productId;
//    private String productName;
//    private String categoryName;
//    private String description;
//    private double unitPrice;
//    private Integer quantity;
}
