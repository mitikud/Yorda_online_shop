package com.yordaonline.shoppingCart.Controller;


import com.yordaonline.shoppingCart.DTO.CartRequest;
import com.yordaonline.shoppingCart.Domain.ShoppingCart;
 import com.yordaonline.shoppingCart.Service.ShoppingCartServiceImplemntation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
//@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST}, allowCredentials = "true", origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceImplemntation cartService;

//    @Autowired
//    public ShoppingCartController(ShoppingCartServiceImplemntation cartService) {
//        this.cartService = cartService;
//    }

    @PostMapping(value = "/create")
    private ResponseEntity create(@RequestBody CartRequest cartRequest) {
        try {
            ShoppingCart cart = cartService.saveOrUpdate(cartRequest);
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Create Cart method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update")
    private ResponseEntity updateProduct(@RequestBody CartRequest cartRequest){
        try {
            CartRequest cart = cartService.updateProduct(cartRequest);
            return new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
        } catch (Exception e){
            log.error("Create Cart method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/cartbycustomerid")
    private ResponseEntity getCartByCustomerId(@RequestBody CartRequest cartRequest) {

        try {
            ShoppingCart cart = cartService.findCartByCustomerId(cartRequest);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Cart by Customer id method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/carts")
    private ResponseEntity getCarts() {
        try {
            List<ShoppingCart> carts = cartService.findAllCarts();
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Cart by Customer id method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
