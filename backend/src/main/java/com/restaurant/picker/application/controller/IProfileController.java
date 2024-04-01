package com.restaurant.picker.application.controller;

import com.restaurant.picker.application.dto.Profile;
import com.restaurant.picker.application.entity.EProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProfileController extends IBaseController<Profile, EProfile, Long> {
    ResponseEntity<Profile> loggingIn(String username, String password);
    ResponseEntity<Profile> registerNewProfile(@RequestBody Profile profile);

}
