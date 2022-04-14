package com.example.vendormodule.service;

import com.example.vendormodule.dto.VendorDto;
import java.util.List;

public interface VendorService {
    VendorDto register(VendorDto request);
     List<VendorDto> getAllVendor();
    VendorDto getVendorById(String id);
    VendorDto updateVendor(String vendorId,VendorDto vendorDto);
    void cancelVendor(String id);
    // ResponseEntity<Object> register2(Vendor request);
}
