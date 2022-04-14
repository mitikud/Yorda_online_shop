package com.example.vendormodule.repository;
import com.example.vendormodule.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {
   @Query("{'id':?0}")
   Vendor findByIdOf(String id);
}
