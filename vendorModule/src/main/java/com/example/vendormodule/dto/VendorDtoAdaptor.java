package com.example.vendormodule.dto;

import com.example.vendormodule.model.Vendor;

public class VendorDtoAdaptor {
    public static Vendor parseVendorDTOToVendor(VendorDto vendorDto) {
        Vendor vendor = new Vendor();
        vendor.setFirstName(vendorDto.getFirstName());
        vendor.setLastName(vendorDto.getLastName());
        vendor.setEmail(vendorDto.getEmail());
        vendor.setPassword(vendorDto.getPassword());
        vendor.setUserName(vendorDto.getUserName());
        return vendor;
    }

    public static VendorDto vendorToVendorDTO(Vendor vendor) {
        VendorDto vendorDto = new VendorDto();
    vendorDto.setVendorId(vendor.getId());
        vendorDto.setFirstName(vendor.getFirstName());
        vendorDto.setLastName(vendor.getLastName());
        vendorDto.setEmail(vendor.getEmail());
        vendorDto.setPassword(vendor.getPassword());
        vendorDto.setUserName(vendor.getUserName());
        return vendorDto;
    }
}
