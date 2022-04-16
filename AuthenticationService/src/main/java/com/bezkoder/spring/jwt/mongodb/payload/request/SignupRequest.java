package com.bezkoder.spring.jwt.mongodb.payload.request;

import com.bezkoder.spring.jwt.mongodb.models.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.*;
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class SignupRequest {
     @NotBlank
     @Size(max = 20)
     private String firstName;
     @NotBlank
     @Size(max = 20)
     private String lastName;
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private ERole roles;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

}
