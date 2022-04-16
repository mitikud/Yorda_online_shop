package com.example.vendormodule.model;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String productName;
    private String description;
    private Integer quantity;
    private double unitPrice;
    private Category category;
    private Status status;
    private Vendor vendorId;
}
