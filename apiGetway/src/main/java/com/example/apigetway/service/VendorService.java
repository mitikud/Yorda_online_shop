package com.example.apigetway.service;

import com.example.apigetway.security.Requests;
import com.example.apigetway.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class VendorService {
    private String vendorUrl = "http://localhost:8080/api/v1/vendor";
    @Autowired
    private UserService userService;

    public ResponseEntity<?> getAllVendor() {
        return Requests.restMethod(vendorUrl, "", "get");

    }

    public ResponseEntity<?> getVendorById(String ven_id) {
        return Requests.restMethod(vendorUrl + "/" + ven_id, "", "get");

    }

    public ResponseEntity<?> updateVendor(Object vendorBody) {
        UserDetail vendor = (UserDetail) userService.getLoggedInUser().getBody();
        return Requests.restMethod(vendorUrl + "/" + vendor.getUserId(), vendorBody, "get");

    }
}
