package com.yordaonline.shoppingCart.DTO;

import com.yordaonline.shoppingCart.Domain.Product;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRequest {

    private String id;
    private String customerId;
    @Singular List<Product> products;

//     public void addProduct(Product product){
//        this.products.add(product);
//    }
}
