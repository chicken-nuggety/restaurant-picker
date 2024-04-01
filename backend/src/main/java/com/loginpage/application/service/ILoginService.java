package com.loginpage.application.service;

import com.loginpage.application.dto.Profile;
import com.loginpage.application.entity.EProfile;

import java.util.Optional;

public interface ILoginService extends IBaseService<Profile, EProfile, Long> {

    Optional<Profile> login(String username, String password);
    Profile register(Profile profile);

}
