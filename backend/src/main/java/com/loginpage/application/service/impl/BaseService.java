package com.loginpage.application.service.impl;

import com.loginpage.application.mapper.BaseMapper;
import com.loginpage.application.repo.IBaseRepo;
import com.loginpage.application.dto.BaseDto;
import com.loginpage.application.entity.BaseEntity;
import com.loginpage.application.service.IBaseService;

import java.io.Serializable;
import java.util.Optional;

public class BaseService<D extends BaseDto<I>, E extends BaseEntity<I>, I extends Serializable> implements IBaseService<D, E, I> {
    protected final IBaseRepo<E, I> repo;
    protected final BaseMapper<E, D> mapper;

    public BaseService(IBaseRepo repo, BaseMapper mapper){
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
