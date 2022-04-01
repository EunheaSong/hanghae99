package com.week5.delivery.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class FoodOrder {

    @Id
    private Long id;

    private String name;

    private int price;

    private int quantity;

}
