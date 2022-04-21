package com.example.adminservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    private String vendorId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private boolean vendorStatus;
    List<Product> productList=new ArrayList<>();
}
