package com.oms.example.orderservice.model;

public enum OrderStatus {
    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    READY("READY"),
    COMPLETED("COMPLETED");

    private final String statusName;

    public String getStatusName() {
        return statusName;
    }

    private OrderStatus(String statusName){
        this.statusName = statusName;
    }
}
