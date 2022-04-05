package com.week5.delivery.domain;

import com.week5.delivery.dto.RestaurantDto;
import com.week5.delivery.validator.RestaurantValidator;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity //음식점 테이블
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name; //매장이름

    private int minOrderPrice; //최소 주문금액

    private int deliveryFee; //배달료

    @OneToMany(mappedBy = "restaurant")  //음식 테이블과 매핑
    private List<Food> foods;

    @OneToMany(mappedBy = "restaurant") // 주문서 테일블과 매핑
    private List<Orders> orders;

    public Restaurant (RestaurantDto restaurantDto) {

        RestaurantValidator.restaurantValidator(restaurantDto);  //최소 주문금액과 배달료 규칙 메서드

        this.name = restaurantDto.getName();
        this.minOrderPrice=restaurantDto.getMinOrderPrice();
        this.deliveryFee =restaurantDto.getDeliveryFee();
    }

    public void addFood(Food food){  //음식을 추가해주는 메서드 . 추가되는 음식의 음식점 변수에 해당 음식점 정보를 넣어준다.

        food.setRestaurant(this);
        this.foods.add(food);
    }

}
