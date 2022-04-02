package com.week5.delivery.controller;


import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.dto.RestaurantDto;
import com.week5.delivery.repository.RestaurantRepository;
import com.week5.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    @PostMapping("/restaurant/register")
    public Restaurant joinRestaurant (@RequestBody RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant(restaurantDto);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> allRestaurant(){
        return restaurantRepository.findAll();
    }
}
