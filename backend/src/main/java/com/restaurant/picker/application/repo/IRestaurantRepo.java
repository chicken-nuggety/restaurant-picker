package com.restaurant.picker.application.repo;

import com.restaurant.picker.application.entity.ERestaurant;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRestaurantRepo extends IBaseRepo<ERestaurant, Long> {
}
