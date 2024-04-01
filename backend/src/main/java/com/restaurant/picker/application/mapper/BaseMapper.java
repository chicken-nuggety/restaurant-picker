package com.restaurant.picker.application.mapper;

import com.restaurant.picker.application.dto.BaseDto;
import com.restaurant.picker.application.entity.BaseEntity;

public interface BaseMapper< E extends BaseEntity<?>, D extends BaseDto<?>> {

    E toEntity(D dto);

    D toDto(E entity);
}
