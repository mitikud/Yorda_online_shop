package com.example.productmodule.dto;
import com.example.productmodule.model.Product;



public class ProductDtoAdaptor {

    public static ProductDto productToProductDto(Product product){

        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setDescription(product.getDescription());
        productDto.setUnitPrice(product.getUnitPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setCategory(product.getCategory());

        return productDto;
    }

    public static Product productDtoToProduct(ProductDto productDto){
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setCategory(productDto.getCategory());
        return product;
    }
}
