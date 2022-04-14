package com.example.vendormodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VendorDto {
    private String vendorId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
}
