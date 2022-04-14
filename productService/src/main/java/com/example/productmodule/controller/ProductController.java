package com.example.productmodule.controller;

import com.example.productmodule.dto.ProductDto;
import com.example.productmodule.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        ProductDto productDto1 = productService.addProduct(productDto);
        log.info("Product added status - {} ");
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1) ;
    }

    @GetMapping
    public List<ProductDto> getAllProduct() {
        return productService.getAllProduct();
    }



   // @GetMapping("/{category}")
    public List<ProductDto> getAllProductCategoryList(@PathVariable String category) {
        return productService.getAllProductCategoryList(category);
    }



    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable String productId) {
        return productService.getByProductId(productId);
    }
    @PutMapping()
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String productId,@RequestBody ProductDto productDto) {
        ProductDto productDto1 = productService.updateProduct(productId,productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productDto1);
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable String productId) {
        productService.deleteByProductId(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
