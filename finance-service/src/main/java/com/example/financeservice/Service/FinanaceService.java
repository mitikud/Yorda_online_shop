package com.example.financeservice.Service;

import com.example.financeservice.Domain.DataSummary;
import com.example.financeservice.Domain.FinancialTransaction;
import com.example.financeservice.Domain.Order;
import com.example.financeservice.Repository.FinanaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class FinanaceService {

    @Autowired
    FinanaceRepository finanaceRepository;

    @Autowired(required = false)
    private orderFeignClient orderFeignClient;


    public void updaterMethod(){
        List<Order> orderList= orderFeignClient.getOrders();
        FinancialTransaction financialTransaction = new FinancialTransaction();
        financialTransaction.setFinancialId("financial1");
        financialTransaction.setOrderList(orderList);
        finanaceRepository.save(financialTransaction);
    }

    public double moneyAfterCalculation(){
        Optional<FinancialTransaction> financialTransaction= finanaceRepository.findById("financial1");
        List<Order> wePay=financialTransaction.get().getOrderList();
        double sumToBePayed=0;
        for (Order order: wePay){
            sumToBePayed=sumToBePayed+(order.getShopingCartt().getTotalPrice());
        }
        return sumToBePayed*0.93;
    }

    public double moneyWePayToVendor(){
        return moneyAfterCalculation()*0.8;
    }

    public double moneyWeReceivedFromCustomer(){
        return moneyAfterCalculation()*0.2;
    }

    public double taxMoneyWePayToState(){
        return moneyAfterCalculation()*0.07;
    }

    public DataSummary getSummaryData() {
        DataSummary dataSummary = new DataSummary();

        dataSummary.setImpureTotalMoney("Impure Money: Money with Tax=  "+(moneyAfterCalculation()/0.97));
        dataSummary.setPureMoney("Pure Money: Money without Tax=  "+ moneyAfterCalculation());
        dataSummary.setMoneyWePay("Paid Money: Money Pay To Vendors=  "+ moneyWePayToVendor());
        dataSummary.setMoneyWeReceived("Received Money: Money Receive From Customers=  "+ moneyWeReceivedFromCustomer());
        dataSummary.setTaxpaid("Tax Paid: Money Paid to State Tax=  " +taxMoneyWePayToState());
        return dataSummary;
    }

    @FeignClient(name = "order-service", url = "http://localhost:8088/orders")
    interface orderFeignClient {
        @GetMapping()
        public List<Order> getOrders();
    }
}
