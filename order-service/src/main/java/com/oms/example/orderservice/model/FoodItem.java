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
    @Column
    private Category category;
    @Column
    private Integer cost;
    @Column
    private Integer quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId",nullable=false)
    private OrderDetails orderDetails;
}
