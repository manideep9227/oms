package com.oms.example.orderservice.service;

import com.oms.example.orderservice.exception.SystemException;
import com.oms.example.orderservice.model.FoodItem;
import com.oms.example.orderservice.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class KitchenService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public FoodItem prepareFood(FoodItem foodItem){
        return foodItemRepository.save(foodItem);
    }

    public FoodItem getFoodItemById(String id){
        return foodItemRepository.findById(id).orElseThrow(SystemException::new);
    }

    public List<FoodItem> getAllFoodItems(){
        return StreamSupport.stream(foodItemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
    public void removeFoodItem(String id){
        removeFoodItem(getFoodItemById(id));
    }
    public void removeFoodItem(FoodItem foodItem){
        foodItemRepository.delete(foodItem);
    }
}
