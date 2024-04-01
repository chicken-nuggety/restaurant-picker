package com.loginpage.application.service;

import com.loginpage.application.dto.Restaurant;
import com.loginpage.application.entity.ERestaurant;

import java.util.Optional;

public interface IRestaurantPickerService extends IBaseService<Restaurant, ERestaurant, Long> {

    Optional<Restaurant> retrieveRandomRestaurant();

}
