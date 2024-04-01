package com.restaurant.picker.application.service;

import com.restaurant.picker.application.dto.BaseDto;
import com.restaurant.picker.application.entity.BaseEntity;

import java.io.Serializable;
import java.util.Optional;

public interface IBaseService<D extends BaseDto<I>, E extends BaseEntity<I>, I extends Serializable> {
    public Optional<D> fetch(I id);
    D save(D dto);
    void deleteById(I id);
}
