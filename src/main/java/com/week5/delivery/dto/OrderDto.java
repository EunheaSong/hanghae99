package com.week5.delivery.dto;

import com.week5.delivery.domain.FoodOrder;
import com.week5.delivery.domain.Orders;
import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.validator.OrderValidator;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class OrderDto {

    private String restaurantName;

    private List<FoodOrderDto> foods;

    private int deliveryFee;

    private int totalPrice;

    public OrderDto (Orders orders){
        this.restaurantName=orders.getRestaurant().getName();
        this.deliveryFee=orders.getRestaurant().getDeliveryFee();
        this.totalPrice= orders.getTotalPrice();

        List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();

        for(int i =0; i<orders.getFoodOrder().size(); i++){
            FoodOrderDto foodOrderDto = new FoodOrderDto();
            foodOrderDto.setPrice(orders.getFoodOrder().get(i).getPrice());
            foodOrderDto.setName(orders.getFoodOrder().get(i).getName());
            foodOrderDto.setQuantity(orders.getFoodOrder().get(i).getQuantity());
            foodOrderDtoList.add(foodOrderDto);
        }
        this.setFoods(foodOrderDtoList);
    }

}
