package com.week5.delivery.domain;

import com.week5.delivery.dto.RestaurantDto;
import com.week5.delivery.validator.RestaurantValidator;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Restaurant {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private int minOrderPrice;

    private int deliveryFee;

    @OneToMany(mappedBy = "restaurant")
    private List<Food> foods;

    public Restaurant (RestaurantDto restaurantDto) {

        RestaurantValidator.restaurantValidator(restaurantDto);

        this.name = restaurantDto.getName();
        this.minOrderPrice=restaurantDto.getMinOrderPrice();
        this.deliveryFee =restaurantDto.getDeliveryFee();
    }

    public void addFood(Food food){

        food.setRestaurant(this);
        this.foods.add(food);
    }

}
