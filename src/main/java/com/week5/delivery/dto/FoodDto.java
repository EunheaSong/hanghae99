package com.week5.delivery.dto;

import com.week5.delivery.domain.Restaurant;
import lombok.Data;
import lombok.Getter;

import javax.persistence.ManyToOne;


@Data
public class FoodDto {

    private String name;

    private int price;

}
