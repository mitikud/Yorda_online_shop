package com.example.vendorservice.Controller;

import com.example.vendorservice.Domain.Product;
import com.example.vendorservice.Domain.Vendor;
import com.example.vendorservice.Repository.VendorRepository;
import com.example.vendorservice.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    VendorService vendorService;

//    @Autowired
//    VendorRepository vendorRepository;


    // Getting All Vendors
    @GetMapping
    public List<Vendor> getAllVendors(){
        return vendorService.getAllVendors();
    }

    // Getting All the Approved Vendors only
    @GetMapping("/approved")
    public List<Vendor> getAllApprovedVendors(){
        return vendorService.getAllVendors().stream().filter(v->v.isVendorStatus()).collect(Collectors.toList());
    }

    // Getting All the UnApproved Vendors only
    @GetMapping("/unApproved")
    public List<Vendor> getAllUnApprovedVendors(){
        return vendorService.getAllVendors().stream().filter(v->!v.isVendorStatus()).collect(Collectors.toList());
    }
    @PostMapping
    public Vendor addNewVendor(@RequestBody Vendor vendor){
        vendor.setVendorStatus(false);
        return vendorService.addNewVendor(vendor);
    }

    @PutMapping("/updateProfile/{vendorId}")
    public Vendor findAndUpdateVendor(@PathVariable String vendorId, @RequestBody Vendor newVendor){
//         Vendor vendor= vendorRepository.findById(vendorId).get();
         Vendor vendor =vendorService.getVendorById(vendorId).get();
                 vendor.setVendorId(vendorId);
                 vendor.setFirstName(newVendor.getFirstName());
                 vendor.setLastName(newVendor.getLastName());
                 vendor.setEmail(newVendor.getEmail());
                 vendor.setUserName(newVendor.getUserName());
                 vendor.setPassword(newVendor.getPassword());
                 vendor.setVendorStatus(vendor.isVendorStatus());
                 vendor.setProductList(newVendor.getProductList());
                 return vendorService.updateVendor(vendor);
    }

    @PutMapping("/updateStatus/{vendorId}")
    public Vendor updateStatusOfVendor(@RequestBody boolean isActiveVednor, @PathVariable String vendorId){
        Vendor vendor=vendorService.getVendorById(vendorId).get();
        vendor.setVendorStatus(isActiveVednor);
        return vendorService.updateVendor(vendor);
    }

    @PatchMapping("/addProduct/{vendorId}")
    public Vendor updateVendorProductList(@RequestBody Product product, @PathVariable String vendorId){
        Vendor vendor = vendorService.getVendorById(vendorId).get();
        List<Product> newProductList= vendor.getProductList();
        newProductList.add(product);
        vendor.setProductList(newProductList);
        return vendorService.updateVendor(vendor);
    }

    @PatchMapping("/removeProduct/{vendorId}")
    public Vendor updateVendorProductListRemove(@RequestBody Product product, @PathVariable String vendorId){
        Vendor vendor = vendorService.getVendorById(vendorId).get();
        List<Product> newProductList= vendor.getProductList();
        newProductList.remove(product);
        vendor.setProductList(newProductList);
        return vendorService.updateVendor(vendor);
    }

    @DeleteMapping("/removeVendor/{vendorId}")
    public void deleteVendorById(@PathVariable String vendorId){
        vendorService.deleteVendorById(vendorId);
    }
}
