package com.yordaonline.shoppingCart.Service;

import com.yordaonline.shoppingCart.Convert.CartRequestToCart;
import com.yordaonline.shoppingCart.DTO.CartRequest;
import com.yordaonline.shoppingCart.Domain.Product;
import com.yordaonline.shoppingCart.Domain.ShoppingCart;
import com.yordaonline.shoppingCart.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImplemntation implements ShoppingCartService {


    private ShoppingCartRepository cartRepository;
    private CartRequestToCart cartRequestToCart;

    @Autowired
    public ShoppingCartServiceImplemntation(ShoppingCartRepository cartRepository, CartRequestToCart cartRequestToCart) {
        this.cartRepository = cartRepository;
        this.cartRequestToCart = cartRequestToCart;
    }
    @Override
    public ShoppingCart saveOrUpdate(CartRequest cartRequest) {
        return cartRepository.save(cartRequestToCart.convert(cartRequest));
    }

    @Override
    public ShoppingCart findCartByCustomerId(CartRequest cartRequest) {
        return cartRepository.findShoppingCartByCustomerId(cartRequest.getCustomerId());
    }

    @Override
    public CartRequest updateProduct(CartRequest cartRequest) {

        ShoppingCart cartInRepo = this.findCartByCustomerId(cartRequest);

        List<Product> productListInRepo= cartInRepo.getProducts();

        for(Product newProduct : cartRequest.getProducts()) {
            for(Product repoPoduct : productListInRepo){
                if(newProduct.getProductNumber().equals(repoPoduct.getProductNumber())){
                    repoPoduct.setQuantity(newProduct.getQuantity());
                    break;
                }else {

                    productListInRepo.add(newProduct);                }
                    System.out.println(newProduct);

            }

        }
        for(Product p: productListInRepo){
            System.out.println(p.toString());
        }
//        CartRequest newCartRequest = CartRequest.builder().id(cartInRepo.getId()).customerId(cartInRepo.getCustomerId()).products(productListInRepo).build();
//        cartRepository.save(cartRequestToCart.convert(newCartRequest));

        return null;

    }

    @Override
    public List<ShoppingCart> findAllCarts() {
        return cartRepository.findAll();
    }








//    @Autowired
//    private ShoppingCartRepository shoppingCartRepo;
//
//
//
//
//    @Override
//    public ShoppingCart addProduct(String cartId, ProductDTO productDTO) {
//        ShoppingCart domain = new ShoppingCart();
//        ProductDTO productDto = new ProductDTO();
//        Optional<ShoppingCart> shoppingCart = shoppingCartRepo.findById(cartId);
//
//        if(shoppingCart.isPresent()){
//            shoppingCart = Optional.ofNullable(shoppingCart.get().addProduct(cartId, productDto));
////            shoppingCart = domain.addProduct(shoppingCart.get(), productAdaptor.toProduct(productDTO)) ;
//
//            shoppingCartRepo.save(shoppingCart.get());
//            ShoppingCartChangeEventDTO shoppingCartChangeEventDTO = new ShoppingCartChangeEventDTO("add product", productDTO,id);
//            shoppingCartChangeSender.send(shoppingCartChangeEventDTO);
//            ShoppingCartAdaptor adaptor = new ShoppingCartAdaptor();
//            ShoppingCartDTO cart = adaptor.toShoppingCartDTO(shoppingCart.get());
//            return cart;
//        }else {
//            ShoppingCartDTO shoppingCart1 = createCart();
//            return addProduct(shoppingCart1.getCartNumber(),productDTO);
//        }    }
//
//    @Override
//    public ShoppingCart removeProduct(String cartId, ProductDTO productDTO) {
//        return null;
//    }
//
//    @Override
//    public ShoppingCart changeProductQuantity(String cartId, String productId, int quantity) throws InterruptedException {
//        return null;
//    }
//
//    @Override
//    public ShoppingCart checkOut(String cartId, String customerId) {
//        return null;
//    }
}
