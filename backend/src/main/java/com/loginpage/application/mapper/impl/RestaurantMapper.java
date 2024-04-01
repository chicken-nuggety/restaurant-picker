package com.loginpage.application.mapper.impl;

import com.loginpage.application.dto.Restaurant;
import com.loginpage.application.entity.ERestaurant;
import com.loginpage.application.mapper.IRestaurantMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class RestaurantMapper implements IRestaurantMapper {

    @Override
    public ERestaurant toEntity(Restaurant dto) {
        ERestaurant entity = new ERestaurant();

        if (dto != null) {
            entity.setId(dto.getId());
            entity.setName(dto.getName());
        }
        return entity;
    }

    @Override
    public Restaurant toDto(ERestaurant entity) {
        Restaurant dto = new Restaurant();

        if (entity != null) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
        }
        return dto;
    }
}
