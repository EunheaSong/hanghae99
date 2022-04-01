package com.week5.delivery.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Food {

    @Id
    private Long id;

    private String name;

    private int price;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;
}
