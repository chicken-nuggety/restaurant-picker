package com.loginpage.application.service;

import com.loginpage.application.dto.Restaurant;
import com.loginpage.application.entity.ERestaurant;
import com.loginpage.application.mapper.IRestaurantMapper;
import com.loginpage.application.repo.IRestaurantRepo;
import com.loginpage.application.service.impl.RestaurantPickerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantPickerServiceTest extends RestaurantPickerService {

    private final IRestaurantRepo repo;
    private final IRestaurantMapper mapper;

    public RestaurantPickerServiceTest(@Mock IRestaurantRepo repo, @Mock IRestaurantMapper mapper) {
        super(repo, mapper);
        this.repo = repo;
        this.mapper = mapper;
    }

    @BeforeEach
    void setup() {
//        ReflectionTestUtils.setField(this, "baseUrl", "https://test.com");
    }

    @Test
    void retrieveRandomRestaurant_Then_Ok(){
//        try (MockedStatic<StaticClass> staticClass = Mockito.mockStatic(StaticClass.class)){
//                staticClass.when(() -> StaticClass.method(anyString())).thenReturn("");
//
//        }
        String name1 = "test 1";
        Long id1 = 1L;

        String name2 = "test 2";
        Long id2 = 2L;

        ERestaurant entity1 = new ERestaurant();
        entity1.setId(id1);
        entity1.setName(name1);

        ERestaurant entity2 = new ERestaurant();
        entity2.setId(id2);
        entity2.setName(name2);

        Restaurant dto1 = new Restaurant();
        dto1.setId(id1);
        dto1.setName(name1);

        Restaurant dto2 = new Restaurant();
        dto2.setId(id2);
        dto2.setName(name2);

        when(repo.findAll()).thenReturn(List.of(entity1, entity2));
        when(mapper.toDto(entity1)).thenReturn(dto1);
        when(mapper.toDto(entity2)).thenReturn(dto2);

        Optional<Restaurant> response = retrieveRandomRestaurant();

        assertTrue(response.isPresent());

    }


    @Test
    void retrieveRandomRestaurant_Then_Empty(){
//        try (MockedStatic<StaticClass> staticClass = Mockito.mockStatic(StaticClass.class)){
//                staticClass.when(() -> StaticClass.method(anyString())).thenReturn("");
//
//        }
//        String name1 = "test 1";
//        Long id1 = 1L;
//
//        String name2 = "test 2";
//        Long id2 = 2L;
//
//        ERestaurant entity1 = new ERestaurant();
//        entity1.setId(id1);
//        entity1.setName(name1);
//
//        ERestaurant entity2 = new ERestaurant();
//        entity2.setId(id2);
//        entity2.setName(name2);
//
//        Restaurant dto1 = new Restaurant();
//        dto1.setId(id1);
//        dto1.setName(name1);
//
//        Restaurant dto2 = new Restaurant();
//        dto2.setId(id2);
//        dto2.setName(name2);

        when(repo.findAll()).thenReturn(Collections.EMPTY_LIST);
//        when(mapper.toDto(entity1)).thenReturn(dto1);
//        when(mapper.toDto(entity2)).thenReturn(dto2);

        Optional<Restaurant> response = retrieveRandomRestaurant();

        assertTrue(response.isEmpty());

    }
}
