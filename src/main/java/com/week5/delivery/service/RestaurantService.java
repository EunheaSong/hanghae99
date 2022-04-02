package com.week5.delivery.service;

import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.dto.RestaurantDto;
import com.week5.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;


}
