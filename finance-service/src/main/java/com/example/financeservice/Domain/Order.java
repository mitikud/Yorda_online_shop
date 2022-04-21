package com.example.financeservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Document
@Data
public class Order {
    private String orderId;
    private ShopingCartt shopingCartt;
    private User user;
}
