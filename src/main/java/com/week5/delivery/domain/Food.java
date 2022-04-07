package com.week5.delivery.domain;


import com.week5.delivery.dto.FoodDto;
import com.week5.delivery.validator.FoodValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity //메뉴 테이블
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; //메뉴의 primary key (기본키)

    @Column(nullable = false)
    private String name; //메뉴 이름

    @Column(nullable = false)
    private int price; // 메뉴 가격

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")  //음식점 테이블과 조인
    private Restaurant restaurant;

    public Food (FoodDto foodDto, Restaurant restaurant){
        FoodValidator.foodValidator(foodDto, restaurant); // 음식에 대한 규칙을 확인해주는 메서드
        this.name = foodDto.getName();
        this.price=foodDto.getPrice();
    }

}
