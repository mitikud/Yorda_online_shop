package com.example.financeservice.Controller;

import com.example.financeservice.Domain.DataSummary;
import com.example.financeservice.Service.FinanaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    FinanaceService finanaceService;

    @GetMapping()
    public void updateTransactions(){
        System.out.println("I AM THE UPDATE INSIDE FINANCE CONTROLLER");
        finanaceService.updaterMethod();
    }


    @GetMapping("/wePay")
    public double moneywePay(){
       return finanaceService.moneyWePayToVendor();
    }

    @GetMapping("/weReceive")
    public double moneyWeReceived(){
       return finanaceService.moneyWeReceivedFromCustomer();
    }

    @GetMapping("/taxWePay")
    public double taxMoneyWePay(){
        return finanaceService.taxMoneyWePayToState();
    }

    @GetMapping("/ImpurPrice")
    public double getImpurePrice(){
        return finanaceService.moneyAfterCalculation()/0.93;
    }
    @GetMapping("/purPrice")
    public double getPurePrice(){
        return finanaceService.moneyAfterCalculation();
    }

    @GetMapping("/dataSummary")
    public DataSummary getFinanceSummary(){
        return finanaceService.getSummaryData();
    }

}
