package com.week5.delivery.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class OrderRequestDto {

    private Long restaurantId;

    private List<FoodOrderRequestDto> foods;

}
