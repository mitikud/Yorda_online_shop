package com.example.shoppingcartservice.Service;

import com.example.shoppingcartservice.Domain.Customer;
import com.example.shoppingcartservice.Domain.Order;
import com.example.shoppingcartservice.Domain.Product;
import com.example.shoppingcartservice.Domain.ShoppingCart;
import com.example.shoppingcartservice.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired(required = false)
    private orderFeignClient orderFeignClient1;

    @Autowired(required = false)
    private customerFeignClient customerFeignClient1;

//    @Autowired
//    private ShoppingCartSender shoppingCartSender; // sender Service


    public void addShoppingcart(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }
    public ShoppingCart getShoppingCart(String id){
        return shoppingCartRepository.findById(id).get();
    }

    public ShoppingCart checkOut(String customerId) {
        System.out.println("getting ready for checkout");
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(customerId);
        System.out.println("THE SHOPPINGCART TO SENT IS: "+shoppingCart);
        if(shoppingCart.isPresent()){
            Order order= new Order();
            Customer customer=customerFeignClient1.getOneUser(customerId).get();
            order.setShoppingCart(shoppingCart.get());
            order.setCustomer(customer);
            orderFeignClient1.addNewOrder(order);
            shoppingCartRepository.deleteById(customerId);
        }
        return null;
    }

    @FeignClient(name = "order-service", url = "http://localhost:8085/orders")
    interface orderFeignClient {
        @PostMapping()
        public void addNewOrder(@RequestBody Order order);
    }

    @FeignClient(name = "customer-service", url = "http://localhost:8083/customers")
    interface customerFeignClient {
        @GetMapping("/{id}")
        public Optional<Customer> getOneUser(@PathVariable String id);
    }


}
