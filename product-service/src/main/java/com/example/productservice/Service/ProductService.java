package com.example.productservice.Service;

import com.example.productservice.Domain.Product;
import com.example.productservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product addNewProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(String productId){
        return productRepository.findById(productId);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategories(String categoryName){
        return productRepository.findByCategory(categoryName);
    }

    public void deleteProduct(String productId){
        productRepository.deleteById(productId);
    }
}
