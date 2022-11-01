package com.oms.service.accountingservice.controller;

import com.oms.service.accountingservice.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountingServiceController {

    @Autowired
    private AccountingService accountingServiceImpl;
    @GetMapping("/getOrders")
    public @ResponseBody String getOrders(){
        return accountingServiceImpl.getOrders();
    }
}
