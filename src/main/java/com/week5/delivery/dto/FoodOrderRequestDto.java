package com.week5.delivery.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodOrderRequestDto {

    Long id; //음식 id

    int quantity; //음식하나를 몇개 주문했는지
}
