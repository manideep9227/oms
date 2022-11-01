package com.oms.example.orderservice.service;

import com.oms.example.orderservice.exception.SystemException;
import com.oms.example.orderservice.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oms.example.orderservice.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> findRestaurantByName(String name){
        return restaurantRepository.findByNameContaining(name);
    }

    public Restaurant insertRestaurantDetails(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public Restaurant findRestaurantById(String id){
        return restaurantRepository.findById(id).orElseThrow(SystemException::new);
    }

    public void deleteRestaurantDetails(Restaurant restaurant){
        restaurantRepository.delete(restaurant);
    }
    public void deleteRestaurantDetails(String restaurantId){
        deleteRestaurantDetails(findRestaurantById(restaurantId));
    }

}
