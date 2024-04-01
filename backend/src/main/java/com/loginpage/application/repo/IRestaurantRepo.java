package com.loginpage.application.repo;

import com.loginpage.application.entity.ERestaurant;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRestaurantRepo extends IBaseRepo<ERestaurant, Long> {
}
