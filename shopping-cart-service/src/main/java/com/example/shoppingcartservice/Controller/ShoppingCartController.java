package com.example.shoppingcartservice.Controller;

import com.example.shoppingcartservice.Domain.Product;
import com.example.shoppingcartservice.Domain.ShoppingCart;
import com.example.shoppingcartservice.Repository.ShoppingCartRepository;
import com.example.shoppingcartservice.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {

    List<Product> newlist = new ArrayList<>();
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired(required = false)
    private productFeignClient productFeignClient1;

    ShoppingCart shoppingCart;

//    @Autowired
//    private ProductRepository productRepository;

    @PostMapping
    public void addShoppingCart(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.addShoppingcart(shoppingCart);
    }

    @PostMapping("/addProduct/{userId}/{productId}")
    public void addProductInShoppingCart(@PathVariable String userId, @PathVariable String productId){
        Product product = productFeignClient1.getApprovedAndAvailableProduct(productId);
        product.setQuantity(1);
        Product product1= productFeignClient1.updateQuantityOfProductDecreaseAmount(1,productId);
        Optional<ShoppingCart> shopcart = shoppingCartRepository.findById(userId);
//        Adapter adapter= new Adapter();
//        Product product = adapter.convertToProductDTO(product.get());

        if(shopcart.isPresent()){

            newlist.addAll(shopcart.get().getProductList());

            newlist.add(product);
            double newTotal= shopcart.get().getTotalPrice();
            shopcart.get().setTotalPrice(newTotal+product.getUnitPrice());
            System.out.println(product);
            shopcart.get().setProductList(newlist);
//            System.out.println("THE PRODUCT IS: "+product+"THE SHOPPINGCART IS: "+shopingCartt);
            shoppingCartService.addShoppingcart(shopcart.get());

        }
        else{
            shoppingCart = new ShoppingCart();
            shoppingCart.setId(userId);
//            newlist = new ArrayList<>();
            newlist.add(product);
            double newTotal= product.getUnitPrice();
//            shopcart.get().setTotalPrice(newTotal+product.get().getUnitPrice());
            shoppingCart.setTotalPrice(newTotal);
            shoppingCart.setProductList(newlist);
            shoppingCartService.addShoppingcart(shoppingCart);
        }

    }

    @GetMapping("/{id}")
    public ShoppingCart getOneShopingCart(@PathVariable String id){
        return shoppingCartService.getShoppingCart(id);
    }

    @PostMapping("/checkOut/{customerId}")
    public ShoppingCart checkOut(@PathVariable String customerId){
        System.out.println("THE CUSTOMERID TO SENT IS: "+customerId);
        return shoppingCartService.checkOut(customerId);
//        return sHopingCartService.getShoppingCart(customerId);
    }

    @FeignClient(name = "product-service", url = "http://localhost:8081/products")
    interface productFeignClient {
        @GetMapping("/{productId}")
        Product getApprovedAndAvailableProduct(@PathVariable String productId);

        @PatchMapping("/updateQuantity/{productId}")
        public Product updateQuantityOfProductDecreaseAmount(@RequestBody Integer productSoldQuantity, @PathVariable String productId);

    }

}
