package com.example.vendormodule.controller;
import com.example.vendormodule.dto.VendorDto;
import com.example.vendormodule.service.VendorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendor")

public class VendorController {
    @Autowired
    private VendorServiceImpl vendorServiceImp;

//    @PostMapping
//    public ResponseEntity<VendorDto> registerVendor(@RequestBody VendorDto vendorDto) {
//
//        VendorDto vendorDto1 = vendorServiceImp.register(vendorDto);
//        return new ResponseEntity<>(vendorDto1,HttpStatus.OK);
//    }
@PreAuthorize("hasAuthority('ROLE_VENDOR')")
    @PutMapping("/{id}")
    public ResponseEntity<VendorDto> updateVendor(@PathVariable String id, @RequestBody VendorDto vendorDto) {
        VendorDto updatedVendor = vendorServiceImp.updateVendor(id, vendorDto);
        return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> cancelVendor(@PathVariable String id) {
        vendorServiceImp.cancelVendor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<VendorDto>> getAllVendor() {
        return new ResponseEntity<>(vendorServiceImp.getAllVendor(), HttpStatus.OK);
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<VendorDto> getVendorById(@PathVariable String vendorId) {
        VendorDto vendor = vendorServiceImp.getVendorById(vendorId);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }
}
