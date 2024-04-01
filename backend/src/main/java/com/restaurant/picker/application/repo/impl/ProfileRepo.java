package com.restaurant.picker.application.repo.impl;

import com.restaurant.picker.application.entity.QEProfile;
import com.restaurant.picker.application.repo.IProfileRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.restaurant.picker.application.entity.EProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.springframework.data.jpa.repository.support.JpaEntityInformationSupport.getEntityInformation;


@Repository
@Transactional
public class ProfileRepo extends BaseRepo<EProfile, Long> implements IProfileRepo {

    private static final QEProfile profile =  QEProfile.eProfile;

    @Autowired
    public ProfileRepo(EntityManager em, JPAQueryFactory qf){
        super(em, qf, (JpaEntityInformation<EProfile, Long>) getEntityInformation(EProfile.class, em));
    }

    @Override
    public Optional<EProfile> retrieveByUserName(String username){
        return Optional.of(qf.selectFrom(profile).where(profile.userName.eq(username)).fetchOne());
    }

}
