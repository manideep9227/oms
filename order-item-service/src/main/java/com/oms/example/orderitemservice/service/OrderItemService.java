package com.oms.example.orderitemservice.service;

import com.oms.example.orderitemservice.exception.OrderItemNotFoundException;
import com.oms.example.orderitemservice.model.OrderItem;
import com.oms.example.orderitemservice.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem getOrderItem(Integer productCode){
        return orderItemRepository.findById(productCode).orElseThrow(OrderItemNotFoundException::new);
    }
    public OrderItem createOrderItem(OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }
}
