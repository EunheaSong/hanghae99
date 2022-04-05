package com.week5.delivery.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodOrderDto {

    String name;

    int quantity;

    int price;

    public FoodOrderDto (FoodOrderRequestDto requestDto, FoodDto foodDto){
        this.setQuantity(requestDto.getQuantity());
        this.setName(foodDto.getName());
        this.setPrice(foodDto.getPrice());
    }

}
