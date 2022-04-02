package com.week5.delivery.validator;

import com.week5.delivery.dto.FoodDto;
import com.week5.delivery.dto.RestaurantDto;
import com.week5.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
public class FoodVaildator {


    public static void foodValidator(FoodDto foodDto) {
//        - 음식점 ID 및 음식 정보 입력받아 등록
//        1. 음식점 ID (restaurantId)
//                1. 음식점 DB 테이블 ID
//        2. 음식명 (name)
//        1. 같은 음식점 내에서는 음식 이름이 중복될 수 없음 (예. '자담치킨 강남점'에 '후라이드치킨' 이 이미 등록되어 있다면 중복하여 등록할 수 없지만, 다른 음식점인 '맘스터치 강남점'에는 '후라이드치킨' 을 등록 가능)
//        3. 가격 (price)
//        1. 허용값: 100원 ~ 1,000,000원
//        2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원 입력 가능)
//        3. 허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴

        if(100 > foodDto.getPrice() || foodDto.getPrice() > 1000000) {
             throw new IllegalArgumentException("가격이 허용치와 맞지 않습니다.");
        }
        if(foodDto.getPrice()%100 !=0){
            throw new IllegalArgumentException("가격은 100원 단위로 입력 가능합니다.");
        }
    }


}
