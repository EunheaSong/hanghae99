package com.week5.delivery.domain;

import com.week5.delivery.dto.FoodDto;
import com.week5.delivery.dto.FoodOrderDto;
import com.week5.delivery.dto.FoodOrderRequestDto;
import com.week5.delivery.validator.OrderValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class FoodOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private int price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "ORDERS_ID")
    private Orders orders;

    public FoodOrder (FoodOrderRequestDto requestDto, Food food){
        OrderValidator.checkFoodOrder(requestDto);

        this.setQuantity(requestDto.getQuantity());
        this.setName(food.getName());
        this.setPrice(food.getPrice()*requestDto.getQuantity());
    }
}
