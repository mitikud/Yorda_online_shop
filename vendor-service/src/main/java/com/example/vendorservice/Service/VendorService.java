package com.example.vendorservice.Service;

import com.example.vendorservice.Domain.Vendor;
import com.example.vendorservice.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(String vendorId){
        return vendorRepository.findById(vendorId);
    }

    public Vendor addNewVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    public void deleteVendorById(String vendorId){
        vendorRepository.deleteById(vendorId);
    }

}
