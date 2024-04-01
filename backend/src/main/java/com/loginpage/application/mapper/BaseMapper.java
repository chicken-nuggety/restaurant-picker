package com.loginpage.application.mapper;

import com.loginpage.application.dto.BaseDto;
import com.loginpage.application.entity.BaseEntity;

public interface BaseMapper< E extends BaseEntity<?>, D extends BaseDto<?>> {

    E toEntity(D dto);

    D toDto(E entity);
}
