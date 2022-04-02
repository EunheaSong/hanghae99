package com.week5.delivery.validator;

import com.week5.delivery.dto.RestaurantDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {

    public static void restaurantValidator(RestaurantDto restaurantDto) {
        //   최소주문 가격 (minOrderPrice)
//         허용값: 1,000원 ~ 100,000원 입력
//         100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원은 입력 가능)
//         허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴
        if (1000 > restaurantDto.getMinOrderPrice() || restaurantDto.getMinOrderPrice() > 100000){
            throw new IllegalArgumentException("최소 주문금액이 허용치와 맞지 않습니다.");
        }
        if (restaurantDto.getMinOrderPrice()%100 != 0){
            throw new IllegalArgumentException("최소 주문금액은 100원 단위로 입력가능합니다.");
        }
//   기본 배달비 (deliveryFee)
//        허용값: 0원 ~ 10,000원
//        500 원 단위로만 입력 가능 (예. 2,200원 입력 시 에러발생. 2,500원 입력 가능)
//        허용값이 아니거나 1,000원 단위 입력이 아닌 경우 에러 발생시킴
        if (0 > restaurantDto.getDeliveryFee() || restaurantDto.getDeliveryFee() > 10000){
            throw new IllegalArgumentException("배달비가 허용치와 맞지 않습니다.");
        }
        if(restaurantDto.getDeliveryFee()%500 != 0){
            throw new IllegalArgumentException("배달비는 500원 단위로 입력가능합니다.");
        }
    }

    public static void checkFoodname (){

    }

}
