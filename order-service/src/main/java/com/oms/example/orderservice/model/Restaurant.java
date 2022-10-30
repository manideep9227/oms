package com.oms.example.orderservice.model;

import java.util.List;

public class Restaurant {

    private String id;
    private String name;
    private String address;
    private Review review;
    private List<FoodItem> menu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    public void setMenu(List<FoodItem> menu) {
        this.menu = menu;
    }
}
