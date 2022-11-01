package com.oms.example.orderservice.controller;

import com.oms.example.orderservice.model.FoodItem;
import com.oms.example.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

/**
 * RestController for creating OrderItems and Retrieving OrderItems based on productCode
 */
@RestController
@RequestMapping("/oms")
public class OrderController {

    private final OrderService orderItemService;

    public OrderController(OrderService orderItemService) {
        this.orderItemService = orderItemService;
    }
    /**
     * API to retrieve OrderItems based on @productCode
     */
    @GetMapping("/getOrderItemInfo/{productCode}")
    public FoodItem getOrderItems(@PathVariable("productCode") Integer productCode){
        return orderItemService.getOrderItem(productCode);
    }
    /**
     * API to create new OrderItems
     */
    @PostMapping("/createNewOrderItem")
    public FoodItem createOrderItem(@RequestBody FoodItem orderItem){
        return orderItemService.createOrderItem(orderItem);
    }
}
