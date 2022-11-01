package com.oms.example.orderservice.repository;

import com.oms.example.orderservice.model.FoodItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem,String> {
}
