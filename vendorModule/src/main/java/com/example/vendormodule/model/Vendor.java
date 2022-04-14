package com.example.vendormodule.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Document(collection = "vendor")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
    @Id
    private String id;
    @NotBlank
    @Size(max = 20)
    private String firstName;
    @NotBlank
    @Size(max = 20)
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 20)
    private String userName;
    @NotBlank
    @Size(max = 20)
    private String password;

}
