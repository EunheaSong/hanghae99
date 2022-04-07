package com.week5.delivery.domain;

import com.week5.delivery.validator.OrderValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name; //음식점 이름.

    @Column(nullable = false)
    private int totalPrice; //총 금액

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID") //음식점 테이블과 조인
    private Restaurant restaurant;

    @OneToMany(mappedBy = "orders") //주문 목록 하나하나를 의미하는 테이블과 조인
    private List<FoodOrder> foodOrder = new ArrayList<>();

    public Orders (Restaurant restaurant1, List<FoodOrder> foodOrder1){

        int total = OrderValidator.checkOrder(restaurant1,foodOrder1);
        //주문 금액을 규칙에 맞게 확인해주는 메서드. 총 금액을 리턴함.

        this.totalPrice = total;
        this.name = restaurant1.getName();
        this.setRestaurant(restaurant1);
        this.setFoodOrder(foodOrder1);

    }



}
