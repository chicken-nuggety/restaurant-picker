package com.restaurant.picker.application.controller.impl;

import com.restaurant.picker.application.controller.IProfileController;
import com.restaurant.picker.application.dto.Profile;
import com.restaurant.picker.application.entity.EProfile;
import com.restaurant.picker.application.service.ILoginService;
import com.restaurant.picker.application.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/profile")
public class ProfileController extends BaseController<Profile, EProfile, Long> implements IProfileController {

    private final IProfileService profileService;
    private final ILoginService loginService;

    @Autowired
    public ProfileController(IProfileService profileService, ILoginService loginService) {
        super(profileService);
        this.profileService = profileService;
        this.loginService = loginService;
    }


    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Profile> loggingIn(String username, String password) {
        Optional<Profile> profile = loginService.login(username, password);
        if (profile.isPresent()) {
            return ResponseEntity.ok(profile.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<Profile> registerNewProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(loginService.register(profile));
    }

}
