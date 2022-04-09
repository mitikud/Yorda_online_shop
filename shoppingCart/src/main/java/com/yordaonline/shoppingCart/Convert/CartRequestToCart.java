package com.yordaonline.shoppingCart.Convert;

 import com.yordaonline.shoppingCart.DTO.CartRequest;
 import com.yordaonline.shoppingCart.Domain.ShoppingCart;
 import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CartRequestToCart implements Converter<CartRequest, ShoppingCart> {

    @Override
    public ShoppingCart convert(CartRequest cartRequest) {
        ShoppingCart cart = new ShoppingCart();
        if (!StringUtils.isEmpty(cartRequest.getId())) {
            cart.setId(cartRequest.getId());
        }
        cart.setCustomerId(cartRequest.getCustomerId());
        cart.setProducts(cartRequest.getProducts());
        return cart;
    }
}
