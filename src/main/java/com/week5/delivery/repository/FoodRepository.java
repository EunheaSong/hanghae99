package com.week5.delivery.repository;

import com.week5.delivery.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {

}
