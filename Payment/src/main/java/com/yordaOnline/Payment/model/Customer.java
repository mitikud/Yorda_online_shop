package com.yordaOnline.Payment.model;

import lombok.Data;

@Data
public class Customer {

      String cid;
      String name;
      String card;
      double price;
      String method;



}
