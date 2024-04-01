package com.restaurant.picker.application.service.impl;

import com.restaurant.picker.application.dto.Restaurant;
import com.restaurant.picker.application.entity.ERestaurant;
import com.restaurant.picker.application.mapper.IRestaurantMapper;
import com.restaurant.picker.application.repo.IRestaurantRepo;
import com.restaurant.picker.application.service.IRestaurantPickerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class RestaurantPickerService extends BaseService<Restaurant, ERestaurant, Long> implements IRestaurantPickerService {

    private final IRestaurantRepo restaurantRepo;
    private final IRestaurantMapper restaurantMapper;

    private Random random;

    @Autowired
    public RestaurantPickerService(IRestaurantRepo restaurantRepo, IRestaurantMapper restaurantMapper){
        super(restaurantRepo,restaurantMapper);
        this.restaurantRepo = restaurantRepo;
        this.restaurantMapper = restaurantMapper;
        this.random = new Random();
    }

    @Override
    public Optional<Restaurant> retrieveRandomRestaurant() {
        List<ERestaurant> eRestaurants = restaurantRepo.findAll();

        if (eRestaurants.isEmpty()){
            return Optional.empty();
        }

        int chosenRestaurantIndex = random.ints(0, eRestaurants.size())
                .findFirst()
                .getAsInt();

        ERestaurant chosenRestaurant = eRestaurants.get(chosenRestaurantIndex);

        return Optional.ofNullable(restaurantMapper.toDto(chosenRestaurant));
    }

}
