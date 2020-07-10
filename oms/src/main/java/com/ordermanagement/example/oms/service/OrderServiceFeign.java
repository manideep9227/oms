package com.ordermanagement.example.oms.service;

import com.ordermanagement.example.oms.model.OrderDetails;
import com.ordermanagement.example.oms.model.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "oderFeign" ,url = "http://localhost:8081/oms")
public interface OrderServiceFeign {
    @GetMapping("/getOrderItemInfo/{productCode}")
    OrderItem fetchOrderItemDetails(@PathVariable("productCode") Integer productCode);

    @PostMapping("/createNewOrderItem")
    OrderItem createOrderItem(@RequestBody OrderItem orderItem);
}

