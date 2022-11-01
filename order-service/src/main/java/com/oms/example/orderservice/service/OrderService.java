package com.oms.example.orderservice.service;

import com.oms.example.orderservice.exception.OrderNotFoundException;
import com.oms.example.orderservice.model.FoodItem;
import com.oms.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderItemRepository) {
        this.orderRepository = orderItemRepository;
    }

    public FoodItem getOrderItem(Integer productCode){
        return orderRepository.findById(productCode).orElseThrow(OrderNotFoundException::new);
    }
    public FoodItem createOrderItem(FoodItem orderItem){
        return orderRepository.save(orderItem);
    }
}
