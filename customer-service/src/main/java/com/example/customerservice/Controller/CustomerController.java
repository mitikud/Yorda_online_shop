package com.example.customerservice.Controller;

import com.example.customerservice.Domain.Customer;
import com.example.customerservice.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

//    @PostMapping()
//    public Customer addCustomer(@RequestBody Customer customer){
//        customer.setCustomerStatus(false);
//        return customerService.addNewCustomer(customer);
//    }

    @GetMapping("/{id}")
    public Optional<Customer> getOneUser(@PathVariable String id){
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> gettingAllTheCustomers(){
        return customerService.getAllCustomers();
    }

    // Getting All the Approved Customers only
    @GetMapping("/Approved")
    public List<Customer> getAllApprovedCustomers(){
        return customerService.getAllCustomers().stream().filter(c->c.isCustomerStatus()).collect(Collectors.toList());
    }

    // Getting All the unApproved Customers only
    @GetMapping("/unApproved")
    public List<Customer> getAllUnApprovedCustomers(){
        return customerService.getAllCustomers().stream().filter(c->!c.isCustomerStatus()).collect(Collectors.toList());
    }

    @PostMapping
    public Customer addNewCustomer(@RequestBody Customer customer){
        customer.setCustomerStatus(false);
        return customerService.addNewCustomer(customer);
    }
@PutMapping("/updateProfile/{customerId}")
    public Customer findAndUpdateCustomer(@PathVariable String customerId, @RequestBody Customer customer){
        Customer customer1= customerService.getCustomerById(customerId).get();

        customer1.setCustomerId(customer1.getCustomerId());
        customer1.setCustomerFirstName(customer.getCustomerFirstName());
        customer1.setCustomerLastName(customer.getCustomerLastName());
        customer1.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
        customer1.setCustomerEmail(customer.getCustomerEmail());
        customer1.setCustomerUsername(customer.getCustomerUsername());
        customer1.setCustomerPassword(customer.getCustomerPassword());
        customer1.setCustomerAddress(customer.getCustomerAddress());
        customer1.setCustomerStatus(customer1.isCustomerStatus());
return customerService.addNewCustomer(customer1);
}

@PutMapping("/updateStatus/{customerId}")
    public Customer updateStatusOfCustomer(@RequestBody boolean isActiveCustomer, @PathVariable String customerId){
        Customer customer = customerService.getCustomerById(customerId).get();

        customer.setCustomerStatus(isActiveCustomer);
        return customerService.addNewCustomer(customer);

}

@DeleteMapping("/removeCustomer/{customerId}")
    public  void deleteCustomerById(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
}

}
