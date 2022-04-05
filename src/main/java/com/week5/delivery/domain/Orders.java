package com.week5.delivery.domain;

import com.week5.delivery.validator.OrderValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name; //음식점 이름.

    private int totalPrice;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "orders")
    private List<FoodOrder> foodOrder = new ArrayList<>();

    public Orders (Restaurant restaurant1, List<FoodOrder> foodOrder1){
        int total = OrderValidator.checkOrder(restaurant1,foodOrder1);
        this.totalPrice = total;
        this.name = restaurant1.getName();
        this.setRestaurant(restaurant1);
        this.setFoodOrder(foodOrder1);
    }

}
