package com.example.productservice.Repository;

import com.example.productservice.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{ 'categoryName' : ?0 }")
    List<Product> findByCategory(String categoryName);
}
