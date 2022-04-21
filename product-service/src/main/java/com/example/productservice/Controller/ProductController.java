package com.example.productservice.Controller;

import com.example.productservice.Domain.Product;
import com.example.productservice.Repository.ProductRepository;
import com.example.productservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

//    @Autowired
//    ProductRepository productRepository;

    // Getting All Products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // Getting All the Approved Products only, which are products for sell

    @GetMapping("/Approved")
    public List<Product> getAllApprovedProducts(){
        return productService.getAllProducts().stream().filter(p->p.isStatus()).collect(Collectors.toList());
    }
    @GetMapping("/Available")
    public List<Product> getAllApprovedAndAvailableProducts(){
        return productService.getAllProducts().stream().filter(p->p.isStatus()&&p.getQuantity()>0).collect(Collectors.toList());
    }
    // Getting All the unApproved Products only
    @GetMapping("/upApproved")
    public List<Product> getAllUnApprovedProducts(){
        return productService.getAllProducts().stream().filter(p->!p.isStatus()).collect(Collectors.toList());
    }

    //Getting a Single Product using it's ID
    @GetMapping("/{productId}")
    public Product getApprovedAndAvailableProduct(@PathVariable String productId){
        return productService.getProductById(productId).get();
    }

    // Adding new Product to products
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        product.setStatus(false);
        return productService.addNewProduct(product);
    }

    @PutMapping("/updateProduct/{productId}")
    public Product findAndUpdateProduct(@PathVariable String productId, @RequestBody Product product){
        Product product1= productService.getProductById(productId).get();
        product1.setProductId(product1.getProductId());
        product1.setProductName(product.getProductName());
        product1.setCategoryName(product.getCategoryName());
        product1.setDescription(product.getDescription());
        product1.setUnitPrice(product.getUnitPrice());
        product1.setQuantity(product.getQuantity());
        product1.setVendorId(product.getVendorId());
        product1.setStatus(product1.isStatus());
        return productService.addNewProduct(product1);
    }

    // Admins can update the Product status, give an approval
@PutMapping("/updateStatus/{productId}")
    public Product updateStatusOfProduct(@RequestBody boolean isApproved, @PathVariable String productId){
        Product product = productService.getProductById(productId).get();
        product.setStatus(isApproved);
        return productService.addNewProduct(product);
}

// Vendors or Admins can update the Product quantity
    @PutMapping("/updateQuantity/{productId}")
    public Product updateQuantityOfProduct(@RequestBody Integer productQuantity, @PathVariable String productId){
        Product product = productService.getProductById(productId).get();
        product.setQuantity(productQuantity);
        return productService.addNewProduct(product);
    }

    // After Customer Buy a Product, quantity must be reduced
    @PatchMapping("/updateQuantity/{productId}")
    public Product updateQuantityOfProductDecreaseAmount(@RequestBody Integer productSoldQuantity, @PathVariable String productId){
        Product product = productService.getProductById(productId).get();
        Integer newQuantity=product.getQuantity()-productSoldQuantity;
        product.setQuantity(newQuantity);
        return productService.addNewProduct(product);
    }


@DeleteMapping("/removeProduct/{productId}")
public void deleteProductById(@PathVariable String productId){
        productService.deleteProduct(productId);
}

}
