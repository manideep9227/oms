package com.oms.service.accountingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "ORDERSERVICE"
)
public interface AccountingService {

    @GetMapping("/oms/getAllOrders")
    String getOrders();
}
