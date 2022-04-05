package com.week5.delivery.dto;


import com.week5.delivery.domain.Food;
import com.week5.delivery.domain.Restaurant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class RestaurantDto {

    private String name;

    private int minOrderPrice;

    private int deliveryFee;

    private List<FoodDto> foods;

    public RestaurantDto(Restaurant restaurant){
        this.name=restaurant.getName();
        this.minOrderPrice=restaurant.getMinOrderPrice();
        this.deliveryFee= restaurant.getMinOrderPrice();
    }
    public RestaurantDto(Restaurant restaurant, List<Food> foods){
        this.name=restaurant.getName();
        this.minOrderPrice=restaurant.getMinOrderPrice();
        this.deliveryFee= restaurant.getMinOrderPrice();

        List<FoodDto> foodDtos = new ArrayList<>();

        for (int i=0; i< foods.size(); i++){
            FoodDto foodDto = new FoodDto();
            foodDto.setId(foods.get(i).getId());
            foodDto.setName(foods.get(i).getName());
            foodDto.setPrice(foods.get(i).getPrice());
            foodDtos.add(foodDto);
        }
        this.setFoods(foodDtos);
    }
}
