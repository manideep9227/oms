package com.oms.example.orderservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String name;
    @Column
    private String address;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<FoodItem> menu;



}
