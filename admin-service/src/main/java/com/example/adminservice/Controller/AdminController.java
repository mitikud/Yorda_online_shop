package com.example.adminservice.Controller;

import com.example.adminservice.Domain.Admin;
import com.example.adminservice.Domain.Customer;
import com.example.adminservice.Domain.Product;
import com.example.adminservice.Domain.Vendor;
import com.example.adminservice.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    AdminService adminService;



    @GetMapping
    public List<Admin> getAllAdmins(){
       return adminService.getAllAdmins();
    }

    @GetMapping("/{adminId}")
    public Admin getAdminById(String adminId){
        return adminService.getAdminById(adminId);
    }

    @PostMapping
    public Admin addNewAdmin(@RequestBody Admin admin){
        return adminService.addNewAdmin(admin);
    }

    // Admin Interaction with the product
    @PatchMapping("/approveProduct/{productId}")
    public Product updateProductStatus(@RequestBody boolean isApproved, @PathVariable String productId){
        return adminService.updateProductStatus(isApproved, productId);
    }

    @GetMapping("/approvedProducts")
    public List<Product> getAllApprovedProductsOnly(){
        return adminService.getAllApprovedProducts();
    }
    @GetMapping("/unApprovedProducts")
    public List<Product> getAllUnApprovedProductsOnly(){
        return adminService.getAllUnApprovedProducts();
    }

// Admin Interaction with Customers
    @PatchMapping("/approveCustomer/{customerId}")
    public Customer updateCustomerStatus(@RequestBody boolean isApproved, @PathVariable String customerId){
        return adminService.updateCustomerStatus(isApproved, customerId);
    }
    @GetMapping("/approvedCustomers")
    public List<Customer> getAllApprovedCustomersOnly(){
        return adminService.getAllApprovedCustomers();
    }
    @GetMapping("/unApprovedCustomers")
    public List<Customer> getAllUnApprovedCustomersOnly(){
        return adminService.getAllUnApprovedCustomers();
    }


    @PatchMapping("/approveVendor/{vendorId}")
    public Vendor update(@RequestBody boolean isApproved, @PathVariable String vendorId){
        return adminService.updateVendorStatus(isApproved, vendorId);
    }

    @GetMapping("/approvedVendors")
    public List<Vendor> getAllApprovedVendorsOnly(){
        return adminService.getAllApprovedVendors();
    }
    @GetMapping("/unApprovedVendors")
    public List<Vendor> getAllUnApprovedVendorsOnly(){
        return adminService.getAllUnApprovedVendors();
    }

//    updateVendorStatus

}
