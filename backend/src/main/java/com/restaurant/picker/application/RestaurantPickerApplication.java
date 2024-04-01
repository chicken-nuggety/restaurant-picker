package com.restaurant.picker.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.restaurant.picker.application.repo"})
public class RestaurantPickerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantPickerApplication.class, args);
	}

}
