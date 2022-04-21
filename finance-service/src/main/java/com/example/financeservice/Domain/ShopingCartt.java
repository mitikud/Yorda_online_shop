package com.example.financeservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ShopingCartt {
    String id;
    List<ProductDTO> productDTOS;
    double totalPrice;
}
