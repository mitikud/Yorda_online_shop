package com.yordaonline.shoppingCart.Service;

import com.yordaonline.shoppingCart.DTO.CartRequest;
import com.yordaonline.shoppingCart.DTO.ProductDTO;
import com.yordaonline.shoppingCart.Domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {





    ShoppingCart saveOrUpdate(CartRequest cartRequest);

    ShoppingCart findCartByCustomerId(CartRequest cartRequest);

    CartRequest updateProduct(CartRequest cartRequest);

    List<ShoppingCart> findAllCarts();



//    ShoppingCart addProduct(String cartId, ProductDTO productDTO);
//    ShoppingCart removeProduct(String cartId, ProductDTO productDTO);
//    ShoppingCart changeProductQuantity(String cartId, String productId, int quantity) throws InterruptedException;
//    ShoppingCart checkOut(String cartId, String customerId);
}
