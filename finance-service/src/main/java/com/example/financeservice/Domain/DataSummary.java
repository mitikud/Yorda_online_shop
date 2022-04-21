package com.example.financeservice.Domain;

import lombok.Data;

@Data
public class DataSummary {
    String impureTotalMoney;
    String pureMoney;
    String moneyWePay;
    String moneyWeReceived;
    String taxpaid;
}
