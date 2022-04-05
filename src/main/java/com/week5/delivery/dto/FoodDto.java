package com.week5.delivery.dto;

import com.week5.delivery.domain.Food;
import com.week5.delivery.domain.Restaurant;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class FoodDto {

    private Long id;

    private String name;

    private int price;

    public FoodDto (Food foods){
        this.setId(foods.getId());
        this.setName(foods.getName());
        this.setPrice(foods.getPrice());
    }
}
