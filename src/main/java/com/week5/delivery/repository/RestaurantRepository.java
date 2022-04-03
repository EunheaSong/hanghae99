package com.week5.delivery.repository;

import com.week5.delivery.domain.Food;
import com.week5.delivery.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
