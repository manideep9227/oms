package com.oms.service.accountingservice.controller;

import com.oms.service.accountingservice.service.AccountingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountingServiceController {
    Logger LOGGER = LoggerFactory.getLogger(AccountingServiceController.class);

    @Autowired
    private AccountingService accountingServiceImpl;
    @GetMapping("/getOrders")
    public @ResponseBody ResponseEntity<String> getOrders(){
        try{
            return new ResponseEntity<>(accountingServiceImpl.getOrders(), HttpStatus.OK);
        }catch (Exception e){
            LOGGER.error("Exception occurred: {}",e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
}
