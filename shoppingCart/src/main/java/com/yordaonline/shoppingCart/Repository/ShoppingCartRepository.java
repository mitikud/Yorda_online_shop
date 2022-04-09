package com.yordaonline.shoppingCart.Repository;

import com.yordaonline.shoppingCart.Domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart,String> {

    ShoppingCart findShoppingCartByCustomerId(String customerId);

 }
