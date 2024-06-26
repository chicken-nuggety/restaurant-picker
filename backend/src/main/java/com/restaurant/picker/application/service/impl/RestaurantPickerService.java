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

    private final IRestaurantRepo repo;
    private final IRestaurantMapper mapper;

    @Autowired
    public RestaurantPickerService(IRestaurantRepo repo, IRestaurantMapper mapper){
        super(repo,mapper);
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Optional<Restaurant> retrieveRandomRestaurant() {
        List<ERestaurant> eRestaurants = repo.findAll();

        if (eRestaurants.isEmpty()){
            return Optional.empty();
        }

        Random random = new Random();

        int chosenRestaurantIndex = 0;

        if(eRestaurants.size() > 1){
            chosenRestaurantIndex = random.ints(0, eRestaurants.size())
                    .findFirst()
                    .getAsInt();
        }

        ERestaurant chosenRestaurant = eRestaurants.get(chosenRestaurantIndex);

        return Optional.ofNullable(mapper.toDto(chosenRestaurant));
    }

}
