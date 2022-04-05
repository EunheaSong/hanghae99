package com.week5.delivery.controller;

import com.week5.delivery.domain.FoodOrder;
import com.week5.delivery.domain.Orders;
import com.week5.delivery.domain.Restaurant;
import com.week5.delivery.dto.OrderDto;
import com.week5.delivery.dto.OrderRequestDto;
import com.week5.delivery.repository.FoodOrderRepository;
import com.week5.delivery.repository.OrderRepository;
import com.week5.delivery.service.OrderService;
import com.week5.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final RestaurantService restaurantService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final FoodOrderRepository foodOrderRepository;

    @PostMapping("/order/request")
    public OrderDto setOrder (@RequestBody OrderRequestDto orderRequestDto){
        Restaurant restaurant = restaurantService.findRestaurant(orderRequestDto.getRestaurantId());
        List<FoodOrder> foodOrder = orderService.addFoodOrder(orderRequestDto.getFoods());
        Orders orders = new Orders(restaurant, foodOrder);
        orderRepository.save(orders);
        for (FoodOrder f : foodOrder){
            f.setOrders(orders);
            foodOrderRepository.save(f);
        }
        OrderDto orderDto = new OrderDto(orders);
        return orderDto;
    }

    @GetMapping("/orders")
    public List<OrderDto> getOrder(){
        return orderService.orderList();
    }
}
