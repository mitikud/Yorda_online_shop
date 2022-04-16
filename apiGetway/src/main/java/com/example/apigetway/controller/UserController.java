package com.example.apigetway.controller;

import com.example.apigetway.constant.RestEndpoints;
import com.example.apigetway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    // Add an user
    @PostMapping(RestEndpoints.REGISTER)
    public ResponseEntity<?> register(@RequestBody Object registrationBody){
        return userService.save(registrationBody);
    }

    // Authenticate a user
    @PostMapping(RestEndpoints.LOGIN)
    public ResponseEntity<?> login(@RequestBody Object loginBody){
        System.out.println("Login body --- "+loginBody);

        return userService.authenticate(loginBody);
    }

    //current user information
    @GetMapping(RestEndpoints.CURRENT)
    public ResponseEntity<?> current(){
        return userService.getLoggedInUser();
    }





}
