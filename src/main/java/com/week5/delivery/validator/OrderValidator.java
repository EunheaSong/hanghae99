package com.week5.delivery.validator;

import com.week5.delivery.domain.FoodOrder;
import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.dto.FoodOrderDto;
import com.week5.delivery.dto.FoodOrderRequestDto;

import java.util.List;

public class OrderValidator {
    //    1. 주문 음식점 이름 (restaurantName)
//2. 주문 음식 정보 (foods)
//    - 주문 음식명 (name)
//    - 주문 수량 (quantity)
//    - 주문 음식의 가격 (price)
//        - 계산방법
//            - 주문 음식 1개의 가격 * 주문 수량
//3. 배달비 (deliveryFee)
//    - 주문 음식점의 기본 배달비
//4. 최종 결제 금액 (totalPrice)
//    - 계산방법
//        - 주문 음식 가격들의 총 합 + 배달비
//    - "주문 음식 가격들의 총 합" 이 주문 음식점의 "최소주문 가격" 을 넘지 않을 시 에러 발생시킴
    public static void checkFoodOrder(FoodOrderRequestDto requestDto) {
        if(requestDto.getQuantity() < 1){
            throw new IllegalArgumentException("주문 수량이 부족합니다");
        }
        if(requestDto.getQuantity() > 100){
            throw new IllegalArgumentException("주문 수량을 초과하였습니다.");
        }
    }

    public static int checkOrder(Restaurant restaurant, List<FoodOrder> foodOrder) {
        int totalPrice = 0;
        for (FoodOrder foodOrder1 : foodOrder) {
            totalPrice += foodOrder1.getPrice();
        }
        System.out.println(totalPrice);
        if (totalPrice < restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException("최소 주문 금액을 확인해주세요.");
        }
        totalPrice += restaurant.getDeliveryFee();
        return totalPrice;
    }
}
