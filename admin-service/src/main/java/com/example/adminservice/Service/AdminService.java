package com.example.adminservice.Service;

import com.example.adminservice.Controller.AdminController;
import com.example.adminservice.Domain.Admin;
import com.example.adminservice.Domain.Customer;
import com.example.adminservice.Domain.Product;
import com.example.adminservice.Domain.Vendor;
import com.example.adminservice.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired(required = false)
    private productFeignClient productFeignClient1;

    @Autowired(required = false)
    private customerFeignClient customerFeignClient1;

    @Autowired(required = false)
    private vendorFeignClient vendorFeignClient1;

    public Admin addNewAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(String adminId) {
        return adminRepository.findById(adminId).get();
    }

    public Product updateProductStatus(boolean Approved, String productId) {
        return productFeignClient1.updateStatusOfProduct(Approved, productId);
    }
    public List<Product> getAllApprovedProducts() {
        return productFeignClient1.getAllApprovedProducts();
    }
    public List<Product> getAllUnApprovedProducts() {
        return productFeignClient1.getAllUnApprovedProducts();
    }

    public Customer updateCustomerStatus(boolean isApproved, String customerId) {
        return customerFeignClient1.updateStatusOfCustomer(isApproved, customerId);
    }
    public List<Customer> getAllApprovedCustomers() {
        return customerFeignClient1.getAllApprovedCustomers();
    }
    public List<Customer> getAllUnApprovedCustomers() {
        return customerFeignClient1.getAllUnApprovedCustomers();
    }


    public Vendor updateVendorStatus(boolean isApproved, String vendorId) {
        return vendorFeignClient1.updateStatusOfVendor(isApproved, vendorId);
    }

    public List<Vendor> getAllApprovedVendors() {
        return vendorFeignClient1.getAllApprovedVendors();
    }
    public List<Vendor> getAllUnApprovedVendors() {
        return vendorFeignClient1.getAllUnApprovedVendors();
    }

    @FeignClient(name = "product-service", url = "http://localhost:8081/products")
    interface productFeignClient {
        @PutMapping("/updateStatus/{productId}")
        public Product updateStatusOfProduct(@RequestBody boolean isApproved, @PathVariable String productId);

        @GetMapping("/Approved")
        public List<Product> getAllApprovedProducts();

        @GetMapping("/upApproved")
        public List<Product> getAllUnApprovedProducts();
    }

    @FeignClient(name = "customer-service", url = "http://localhost:8083/customers")
    interface customerFeignClient {
        @PutMapping("/updateStatus/{customerId}")
        public Customer updateStatusOfCustomer(@RequestBody boolean isActiveCustomer, @PathVariable String customerId);

        // Getting All the Approved Customers only
        @GetMapping("/Approved")
        public List<Customer> getAllApprovedCustomers();

        // Getting All the unApproved Customers only
        @GetMapping("/unApproved")
        public List<Customer> getAllUnApprovedCustomers();
    }

    @FeignClient(name = "vendor-service", url = "http://localhost:8082/vendors")
    interface vendorFeignClient {
        @PutMapping("/updateStatus/{vendorId}")
        public Vendor updateStatusOfVendor(@RequestBody boolean isActiveVednor, @PathVariable String vendorId);

        // Getting All the Approved Vendors only
        @GetMapping("/approved")
        public List<Vendor> getAllApprovedVendors();

        // Getting All the UnApproved Vendors only
        @GetMapping("/unApproved")
        public List<Vendor> getAllUnApprovedVendors();
    }
}