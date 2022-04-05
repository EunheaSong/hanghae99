package com.week5.delivery.controller;


import com.week5.delivery.domain.Food;
import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.dto.FoodDto;
import com.week5.delivery.dto.RestaurantDto;
import com.week5.delivery.repository.FoodRepository;
import com.week5.delivery.repository.RestaurantRepository;
import com.week5.delivery.service.FoodService;
import com.week5.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;
    private final FoodService foodService;
    private final FoodRepository foodRepository;

    //음식점 등록하기
    @PostMapping("/restaurant/register")
    public Restaurant joinRestaurant (@RequestBody RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant(restaurantDto);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    //음식점 조회하기
    @GetMapping("/restaurants")
    public List<Restaurant> allRestaurant(){
        return restaurantRepository.findAll();
    }

    //특정 음식점에 메뉴 등록하기
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void saveFood (@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDto){
        System.out.println("요기"+restaurantId);
        Restaurant restaurant = restaurantService.findRestaurant(restaurantId);
        System.out.println("현재 음식점 메뉴 수" + restaurantService.findRestaurant(restaurantId).getFoods().size());
        restaurantService.addFoods(foodDto, restaurant);

        System.out.println("저장 후 음식점 메뉴 수" + restaurantService.findRestaurant(restaurantId).getFoods().size());

    }

    //특정 음식점의 메뉴판 목록 조회하기
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodDto> foodList (@PathVariable Long restaurantId){
        System.out.println("리스트조회"+restaurantId);
        Restaurant restaurant = restaurantService.findRestaurant(restaurantId);
        RestaurantDto restaurantDto = new RestaurantDto(restaurant, restaurant.getFoods());

        return restaurantDto.getFoods();
    }
}
