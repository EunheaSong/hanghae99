package com.week5.delivery.repository;

import com.week5.delivery.domain.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
}
