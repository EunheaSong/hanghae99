package com.week5.delivery.domain;

import com.week5.delivery.dto.FoodOrderRequestDto;
import com.week5.delivery.validator.OrderValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity //메뉴와 수량을 선택해서 장바구니에 담는.. 주문목록 하나하나를 의미하는 테이블
public class FoodOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; //pimary key 기본키

    @Column(nullable = false)
    private String name; //메뉴 이름

    @Column(nullable = false)
    private int price; //메뉴의 총 금액 (메뉴 가격 * 선택 수랑)

    @Column(nullable = false)
    private int quantity; //메뉴 수량 (한 메뉴를 몇개 주문했는지 대한 수량)

    @ManyToOne
    @JoinColumn(name = "ORDERS_ID") //주문서 테이블과 조인.
    private Orders orders;

    public FoodOrder (FoodOrderRequestDto requestDto, Food food){
        OrderValidator.checkFoodOrder(requestDto); //메뉴 수량을 잘 체크했는지 확인하는 규칙 메서드

        this.setQuantity(requestDto.getQuantity());
        this.setName(food.getName());
        this.setPrice(food.getPrice()*requestDto.getQuantity());
    }
}
