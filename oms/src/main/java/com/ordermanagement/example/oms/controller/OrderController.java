package com.ordermanagement.example.oms.controller;

import com.ordermanagement.example.oms.model.OrderDetails;
import com.ordermanagement.example.oms.model.OrderItem;
import com.ordermanagement.example.oms.service.OrderService;
import com.ordermanagement.example.oms.service.OrderServiceFeign;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("oms/")
public class OrderController {

    private final OrderService orderService;
    private final OrderServiceFeign orderServiceFeign;

    public OrderController(OrderService orderService, OrderServiceFeign orderServiceFeign) {
        this.orderService = orderService;
        this.orderServiceFeign = orderServiceFeign;
    }

    @GetMapping("getOrderInfo/{orderId}")
    public OrderDetails getOrders(@PathVariable("orderId") String orderId){
        return orderService.getOrderItem(orderId);
    }

    @PostMapping("createNewOrder")
    public OrderDetails createOrders(@RequestBody OrderDetails order){
        return orderService.createOrderItem(order);
    }

    @GetMapping("getOrderItemInfo/{productCode}")
    public OrderItem getOrderItems(@PathVariable("productCode") Integer productCode){
        return orderServiceFeign.fetchOrderItemDetails(productCode);
    }

    @PostMapping("createNewOrderItem")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem){
        return orderServiceFeign.createOrderItem(orderItem);
    }
}
