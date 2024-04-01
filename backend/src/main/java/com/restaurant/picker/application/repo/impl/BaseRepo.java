package com.restaurant.picker.application.repo.impl;

import com.restaurant.picker.application.repo.IBaseRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.restaurant.picker.application.entity.BaseEntity;

import jakarta.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public class BaseRepo<E extends BaseEntity<I>, I extends Serializable> extends SimpleJpaRepository<E, I> implements IBaseRepo<E, I> {

    protected final EntityManager em;
    protected final JPAQueryFactory qf;

    public BaseRepo(EntityManager em, JPAQueryFactory qf, JpaEntityInformation<E, I> ei){
        super(ei, em);
        this.em = em;
        this.qf = qf;
    }


}
