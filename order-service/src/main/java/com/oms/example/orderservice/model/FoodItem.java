package com.oms.example.orderservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class FoodItem {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String foodId;
    @Column
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Category category;
    @Column
    private Integer cost;
    @Column
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="orderId")
    @ToString.Exclude
    private OrderDetails orderDetails;

    @ManyToOne
    @JoinColumn(name="restaurantId")
    @ToString.Exclude
    private Restaurant restaurant;


}
