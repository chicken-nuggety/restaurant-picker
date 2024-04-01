package com.restaurant.picker.application.service;

import com.restaurant.picker.application.dto.Profile;
import com.restaurant.picker.application.entity.EProfile;

import java.util.Optional;

public interface ILoginService extends IBaseService<Profile, EProfile, Long> {

    Optional<Profile> login(String username, String password);
    Profile register(Profile profile);

}
