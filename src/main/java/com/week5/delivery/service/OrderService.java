package com.week5.delivery.service;

import com.week5.delivery.domain.Food;
import com.week5.delivery.domain.FoodOrder;
import com.week5.delivery.domain.Orders;
import com.week5.delivery.dto.FoodOrderRequestDto;
import com.week5.delivery.dto.OrderDto;
import com.week5.delivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final FoodService foodService;
    private final OrderRepository orderRepository;


    @Transactional
    public List<FoodOrder> addFoodOrder (List<FoodOrderRequestDto> requestDto){
        List<FoodOrder> foodOrderList = new ArrayList<>();

        for (FoodOrderRequestDto f : requestDto){
            Food food = foodService.findFood(f.getId());
            FoodOrder foodOrder = new FoodOrder(f,food);
            foodOrderList.add(foodOrder);
        }
        return foodOrderList;
    }

    @Transactional
    public List<OrderDto> orderList() {
        List<Orders> ordersList = orderRepository.findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();
        System.out.println("ordersList 사이즈" + ordersList.size());
        System.out.println("ordersList 매장 이름 " + ordersList.get(0).getName());
        System.out.println("ordersList 메뉴 목록 "+ ordersList.get(0).getFoodOrder().size());

        for (Orders o : ordersList) {
            OrderDto orderDto = new OrderDto(o);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

}
