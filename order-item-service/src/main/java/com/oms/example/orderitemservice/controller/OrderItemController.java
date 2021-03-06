package com.oms.example.orderitemservice.controller;

import com.oms.example.orderitemservice.model.OrderItem;
import com.oms.example.orderitemservice.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * RestController for creating OrderItems and Retreiving OrderItems based on productCode
 */
@RestController
@RequestMapping("/oms")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
    /**
     * API to retrieve OrderItems based on @productCode
     */
    @GetMapping("/getOrderItemInfo/{productCode}")
    public OrderItem getOrderItems(@PathVariable("productCode") Integer productCode){
        return orderItemService.getOrderItem(productCode);
    }
    /**
     * API to create new OrderItems
     */
    @PostMapping("/createNewOrderItem")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem){
        return orderItemService.createOrderItem(orderItem);
    }
}
