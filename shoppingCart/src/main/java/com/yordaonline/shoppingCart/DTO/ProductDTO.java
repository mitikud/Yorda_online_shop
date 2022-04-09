package com.yordaonline.shoppingCart.DTO;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String productNumber;
    private String name;
    private double price;
    private String description;
//    private int quantity;
}
