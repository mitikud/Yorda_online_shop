package com.example.productmodule.service;

import com.example.productmodule.dto.ProductDto;
import com.example.productmodule.dto.ProductDtoAdaptor;
import com.example.productmodule.exception.ResourceNotFoundException;
import com.example.productmodule.model.Product;
import com.example.productmodule.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDto addProduct(ProductDto productDto) {
        Product product1 = ProductDtoAdaptor.productDtoToProduct(productDto);
        productRepository.save(product1);
        ProductDto productDto1 = ProductDtoAdaptor.productToProductDto(product1);
        return productDto1;
    }


    public List<ProductDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDto = new ArrayList<>();
        for (Product p : productList) {
            productDto.add(ProductDtoAdaptor.productToProductDto(p));

        }
        return productDto;
    }

    public ProductDto getByProductId(String productId) {
        Product product = productRepository.findById(productId).orElse(null);
        ProductDto productDto = ProductDtoAdaptor.productToProductDto(product);
        return productDto;
    }

    public void deleteByProductId(String productId) {
        Product product = productRepository.findById(productId).orElse(null);
        productRepository.delete(product);
    }

    public List<ProductDto> getAllProductCategoryList(String category) {
        return getAllProduct().stream().filter(productDto -> productDto.getCategory()
                .getName().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    public ProductDto productByIdStream(String productId) {
        return getAllProduct().stream().filter(productDto -> productDto.getProductId() == productId)
                .findAny().get();
    }


    public ProductDto updateProduct(String productId, ProductDto productDto) {
        Product product = productRepository.findById(productId).orElse(null);
        Product product1 = ProductDtoAdaptor.productDtoToProduct(productDto);
        product.setProductName(product1.getProductName());
        product.setQuantity(product1.getQuantity());
        product.setUnitPrice(product1.getUnitPrice());
        product.setDescription(product1.getDescription());
        product.setCategory(product1.getCategory());
        ProductDto productDto1 = ProductDtoAdaptor.productToProductDto(product1);
        return productDto1;
    }
}
