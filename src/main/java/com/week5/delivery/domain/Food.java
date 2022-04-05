package com.week5.delivery.domain;


import com.week5.delivery.dto.FoodDto;
import com.week5.delivery.validator.FoodVaildator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private int price;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    public Food (FoodDto foodDto, Restaurant restaurant){
        FoodVaildator.foodValidator(foodDto, restaurant);
        this.name = foodDto.getName();
        this.price=foodDto.getPrice();
    }

}
