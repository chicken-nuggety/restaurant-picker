package com.restaurant.picker.application.controller.impl;

import com.restaurant.picker.application.dto.Restaurant;
import com.restaurant.picker.application.entity.ERestaurant;
import com.restaurant.picker.application.service.IRestaurantPickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController extends BaseController<Restaurant, ERestaurant, Long> {

    private final IRestaurantPickerService service;

    @Autowired
    public RestaurantController(IRestaurantPickerService service) {
        super(service);
        this.service = service;
    }

    // Used as a temporary solution due to lack client server
    @CrossOrigin
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/random")
    public ResponseEntity<Restaurant> getRandomRestaurant() {
        Optional<Restaurant> restaurant = service.retrieveRandomRestaurant();
        return restaurant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
