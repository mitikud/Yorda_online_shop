package com.example.financeservice.Domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ProductDTO {
    private String productId;
    private String productName;
    private String categoryName;
    private String description;
    private double unitPrice;
    private Integer quantity;
}
