package com.example.productmodule.dto;

import com.example.productmodule.model.Category;
import lombok.Data;

@Data
public class ProductDto {
    private String productId;
    private String productName;
    private String description;
    private Integer quantity;
    private double unitPrice;
    private Category category;

}
