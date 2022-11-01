package com.oms.example.orderservice.controller;

import com.oms.example.orderservice.model.FoodItem;
import com.oms.example.orderservice.model.OrderDetails;
import com.oms.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController for creating OrderItems and Retrieving OrderItems based on orderId
 */
@RestController
@RequestMapping("/oms")
public class OrderController {

    @Autowired
    private OrderService orderItemService;

    /**
     * API to retrieve OrderItems based on @orderId
     */
    @GetMapping("/getOrderItemInfo/{orderId}")
    public OrderDetails getOrderItems(@PathVariable("orderId") String orderId){
        return orderItemService.getOrderItem(orderId);
    }
    /**
     * API to create new OrderItems
     */
    @PostMapping("/createNewOrderItem")
    public OrderDetails createOrderItem(@RequestBody OrderDetails orderItem){
        return orderItemService.createOrderItem(orderItem);
    }
    @GetMapping("/getAllOrders")
    public @ResponseBody List<OrderDetails> getAllOrders(){
        return orderItemService.getOrders();
    }
}
