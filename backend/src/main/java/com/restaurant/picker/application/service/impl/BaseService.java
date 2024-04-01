package com.restaurant.picker.application.service.impl;

import com.restaurant.picker.application.mapper.BaseMapper;
import com.restaurant.picker.application.repo.IBaseRepo;
import com.restaurant.picker.application.dto.BaseDto;
import com.restaurant.picker.application.entity.BaseEntity;
import com.restaurant.picker.application.service.IBaseService;

import java.io.Serializable;
import java.util.Optional;

public class BaseService<D extends BaseDto<I>, E extends BaseEntity<I>, I extends Serializable> implements IBaseService<D, E, I> {
    protected final IBaseRepo<E, I> repo;
    protected final BaseMapper<E, D> mapper;

    public BaseService(IBaseRepo<E, I> repo, BaseMapper<E, D> mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Optional<D> fetch(I id){return repo.findById(id).map(mapper::toDto);}
    @Override
    public D save(D dto){return mapper.toDto(repo.save(mapper.toEntity(dto)));}

    @Override
    public void deleteById(I id){repo.deleteById(id);}
}
