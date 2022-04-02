package com.week5.delivery.service;

import com.week5.delivery.domain.Food;
import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.dto.FoodDto;
import com.week5.delivery.repository.FoodRepository;
import com.week5.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    public Restaurant findRestaurant (Long id){
        return restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 매장입니다")
        );
    }

    public Restaurant findFoodname (Long id, List<FoodDto> foodDto){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 매장입니다")
        );
        List<Food> foods = restaurant.getFood();
        for (Food food : foods) {
            for (FoodDto dto : foodDto) {
                if (food.getName().equals(dto.getName())) {
                    throw new IllegalArgumentException("이미 등록된 메뉴입니다.");
                }
                Food foodadd = new Food(dto, restaurant);
                foodRepository.save(foodadd);
                restaurant.getFood().add(foodadd);
            }
        }
        return restaurant;
    }





}
