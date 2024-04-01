package com.restaurant.picker.application.mapper.impl;

import com.restaurant.picker.application.dto.Restaurant;
import com.restaurant.picker.application.entity.ERestaurant;
import com.restaurant.picker.application.mapper.IRestaurantMapper;
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
            entity.setActive(Boolean.TRUE.equals(dto.getIsActive()));
            entity.setCreatedBy(dto.getCreatedBy());
            entity.setCreatedTime(dto.getCreatedTime());
            entity.setModifiedBy(dto.getModifiedBy());
            entity.setModifiedTime(dto.getModifiedTime());
        }
        return entity;
    }

    @Override
    public Restaurant toDto(ERestaurant entity) {
        Restaurant dto = new Restaurant();

        if (entity != null) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setIsActive(entity.isActive());
            dto.setCreatedBy(entity.getCreatedBy());
            dto.setCreatedTime(entity.getCreatedTime());
            dto.setModifiedBy(entity.getModifiedBy());
            dto.setModifiedTime(entity.getModifiedTime());
        }
        return dto;
    }
}
