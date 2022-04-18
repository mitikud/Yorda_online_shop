package com.yordaOnline.Payment.controller;


import com.yordaOnline.Payment.Service.PaymentService;
import com.yordaOnline.Payment.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST}, allowCredentials = "true", origins = "*", maxAge = 3600)
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;


//
//    public static final String SUCCESS_URL = "pay/success";
//    public static final String CANCEL_URL = "pay/cancel";

    @PostMapping("/pay")
    public Boolean payment(@RequestBody Customer customer) {
//        try {
//            return paymentService.validateCard(customer.getCard()).toString();
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//        return "False";
        return paymentService.validateCard(customer.getCard());

    }

    @GetMapping
    String test(){
        return "Hello";
    }
}
