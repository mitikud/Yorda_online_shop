package com.example.apigetway.controller;

import com.example.apigetway.constant.RestEndpoints;
import com.example.apigetway.service.UserService;
import com.example.apigetway.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class VendorController {
    private VendorService vendorService;
    @Autowired
    public VendorController(VendorService vendorService){
        this.vendorService = vendorService;
    }

    // Retrieves all vendors
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(RestEndpoints.VENDOR_PREFIX)
    public ResponseEntity<?> getAllVendor(){
        System.out.println("Here are all the vendors --- ");
        return vendorService.getAllVendor();
    }

    // Retrieve a specific vendor
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(RestEndpoints.VENDOR_PREFIX+RestEndpoints.VENDOR_BY_ID)
    public ResponseEntity<?> getVendorByID(@PathVariable String ven_id){
        System.out.println("vendor Id --- "+ven_id);
        return vendorService.getVendorById(ven_id);
    }

    // update vendor
    @PreAuthorize("hasAuthority('ROLE_ADMIN' || 'ROLE_VENDOR')")
    @PutMapping(RestEndpoints.PRODUCTS_PREFIX+RestEndpoints.VENDOR_BY_ID)


    public ResponseEntity<?> updateVendor(@PathVariable String vendorId,@RequestBody Object vendorBody){
        System.out.println("vendor Body --- "+vendorBody);
        return vendorService.updateVendor(vendorBody);
    }


}
