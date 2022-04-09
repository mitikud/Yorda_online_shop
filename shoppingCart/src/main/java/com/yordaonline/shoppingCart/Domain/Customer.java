package com.yordaonline.shoppingCart.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private String Id;
    private String firstName;
    private String address;
    private String email;
}
