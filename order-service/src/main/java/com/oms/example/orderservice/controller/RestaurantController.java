package com.oms.example.orderservice.controller;

import com.oms.example.orderservice.model.Restaurant;
import com.oms.example.orderservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oms/restaurant/")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/findRestaurant/{restaurantName")
    public @ResponseBody List<Restaurant> findRestaurant(@PathVariable("restaurantName") String name) {
        return restaurantService.findRestaurantByName(name);
    }

    @PostMapping("/insertRestaurantDetails")
    public @ResponseBody Restaurant insertRestaurantDetails(@RequestBody Restaurant restaurant){
        return restaurantService.insertRestaurantDetails(restaurant);
    }
}
