package com.example.productmodule.repository;

import com.example.productmodule.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
//    @Query("{'id':?0}")
//    Product findByIdOf(String id);
}
