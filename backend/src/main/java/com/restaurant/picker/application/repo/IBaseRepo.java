package com.restaurant.picker.application.repo;

import com.restaurant.picker.application.entity.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IBaseRepo<E extends BaseEntity<I>, I extends Serializable> extends JpaRepositoryImplementation<E, I> {
}
