package com.example.apigetway.service;

import com.example.apigetway.security.Requests;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private String signUpUrl="http://localhost:9093/api/auth/signup";
    private String signInUrl="http://localhost:9093/api/auth/signin";



    public ResponseEntity<?> save(Object registrationBody) {
        return Requests.restMethod(signUpUrl, registrationBody, "post");
    }

    public ResponseEntity<?> authenticate(Object loginBody) {
        return Requests.restMethod(signInUrl, loginBody, "post");
    }


    public ResponseEntity<?> getLoggedInUser() {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getDetails();
            return ResponseEntity.ok().body(principal);
        }


}
