package com.example.vendorservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

    @Id
    private String vendorId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private boolean vendorStatus;
    List<Product> productList=new ArrayList<>();
}
