package com.week5.delivery.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Order {

    @Id
    private Long id;

    private String name; //음식점 이름.

    private int totalPrice;


}
