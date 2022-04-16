package com.example.vendormodule.service;

import com.example.vendormodule.dto.VendorDto;
import com.example.vendormodule.dto.VendorDtoAdaptor;
import com.example.vendormodule.model.Vendor;
import com.example.vendormodule.repository.VendorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public VendorDto register(VendorDto vendor) {
      Vendor vendor1 = VendorDtoAdaptor.parseVendorDTOToVendor(vendor);
        vendorRepository.save(vendor1);
        VendorDto vendorDto=VendorDtoAdaptor.vendorToVendorDTO(vendor1);
        return vendorDto;
    }

    @KafkaListener(topics = "vendorRegistered", groupId ="1")
    public void listen(String vendorData) {
        Gson g = new Gson();
        System.out.println("Vendor Data: "+vendorData);
        VendorDto vendorDto = g.fromJson(vendorData, VendorDto.class);
        register(vendorDto);
        System.out.println("Received Message in group -id 1 : " + vendorData);
    }

    @Override
    public List<VendorDto> getAllVendor() {
        List<VendorDto> vendorDtos = new ArrayList<>();
        List<Vendor> allVendors = vendorRepository.findAll();
        for (Vendor vendor : allVendors) {
            vendorDtos.add(VendorDtoAdaptor.vendorToVendorDTO(vendor));
        }
        return vendorDtos;
    }

    @Override
    public VendorDto getVendorById(String vendorId) {
        Vendor vendor1 = vendorRepository.findByIdOf(vendorId);
        VendorDto v1 = VendorDtoAdaptor.vendorToVendorDTO(vendor1);
        return v1;
    }
    @Override
    public void cancelVendor(String vendorId) {
        Vendor vendor1 = vendorRepository.findByIdOf(vendorId);
        vendorRepository.delete(vendor1);
        System.out.println("vendor is deleted successfully");
    }
    //
    @Override
    public VendorDto updateVendor(String vendorId, VendorDto vendorDto) {
        Vendor vendor1 =VendorDtoAdaptor.parseVendorDTOToVendor(vendorDto);
        Vendor vendor2 = vendorRepository.findByIdOf(vendorId);
        vendor2.setId(vendorId);
        vendor2.setFirstName(vendor1.getFirstName());
        vendor2.setLastName(vendor1.getLastName());
        vendor2.setEmail(vendor1.getEmail());
        vendor2.setUserName(vendor1.getUserName());
        vendor2.setPassword(vendor1.getPassword());
      Vendor vendor=  vendorRepository.save(vendor2);
      VendorDto vendorDto1 = VendorDtoAdaptor.vendorToVendorDTO(vendor);
        return vendorDto1;
    }

}
