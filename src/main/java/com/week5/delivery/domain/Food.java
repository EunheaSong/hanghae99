package com.week5.delivery.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private int price;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;
}
