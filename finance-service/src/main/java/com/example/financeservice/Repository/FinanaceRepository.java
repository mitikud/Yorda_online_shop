package com.example.financeservice.Repository;

import com.example.financeservice.Domain.FinancialTransaction;
import com.example.financeservice.Domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanaceRepository extends MongoRepository<FinancialTransaction, String> {
}
