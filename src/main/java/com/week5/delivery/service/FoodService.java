package com.week5.delivery.service;

import com.week5.delivery.domain.Food;
import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.dto.FoodDto;
import com.week5.delivery.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

//    public List<Food> CheckFood(Restaurant restaurant, List<FoodDto> foodDtos){
//        foodRepository.findBy
//    }
//

}
