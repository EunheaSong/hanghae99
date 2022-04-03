package com.week5.delivery.service;

import com.week5.delivery.domain.Food;
import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.dto.FoodDto;
import com.week5.delivery.repository.FoodRepository;
import com.week5.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodService foodService;

    public Restaurant findRestaurant (Long id){
        return restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 매장입니다")
        );
    }

    public void addFoods (List<FoodDto> foodDto,Restaurant restaurant){
        for (FoodDto f : foodDto){
            Food food = new Food(f,restaurant);
            restaurant.addFood(food);
        }
        restaurantRepository.save(restaurant);
    }



}
