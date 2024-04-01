package com.loginpage.application.controller;

import com.loginpage.application.dto.Profile;
import com.loginpage.application.entity.EProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProfileController extends IBaseController<Profile, EProfile, Long> {
    ResponseEntity<Profile> loggingIn(String username, String password);
    ResponseEntity<Profile> registerNewProfile(@RequestBody Profile profile);

}
