package com.restaurant.picker.application.repo.impl;

import com.restaurant.picker.application.entity.ERestaurant;
import com.restaurant.picker.application.entity.QERestaurant;
import com.restaurant.picker.application.repo.IRestaurantRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.springframework.data.jpa.repository.support.JpaEntityInformationSupport.getEntityInformation;

@Repository
@Transactional
public class RestaurantRepo extends BaseRepo<ERestaurant, Long> implements IRestaurantRepo {

    private static final QERestaurant restaurant = QERestaurant.eRestaurant;

    @Autowired
    public RestaurantRepo(EntityManager em, JPAQueryFactory qf) {
        super(em, qf, (JpaEntityInformation<ERestaurant, Long>) getEntityInformation(ERestaurant.class, em));
    }

}
