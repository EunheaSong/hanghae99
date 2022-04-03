package com.week5.delivery.dto;


import com.week5.delivery.domain.Food;
import lombok.Data;


import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class RestaurantDto {

    private String name;

    private int minOrderPrice;

    private int deliveryFee;

}
