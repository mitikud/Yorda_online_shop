package com.example.customerservice.Service;

import com.example.customerservice.Domain.Customer;
import com.example.customerservice.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer addNewCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(String customerId){
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public void deleteCustomer(String customerId){
        customerRepository.deleteById(customerId);
    }
}
