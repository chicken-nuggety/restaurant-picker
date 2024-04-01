package com.restaurant.picker.application.service;

import com.restaurant.picker.application.dto.Restaurant;
import com.restaurant.picker.application.entity.ERestaurant;

import java.util.Optional;

public interface IRestaurantPickerService extends IBaseService<Restaurant, ERestaurant, Long> {

    Optional<Restaurant> retrieveRandomRestaurant();

}
