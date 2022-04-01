package com.week5.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Restaurant {

    @Id
    private Long id;

    private String name;

    private int minOrderPrice;

    private int deliveryFee;

    @OneToMany
    private List<Food> food;


}
