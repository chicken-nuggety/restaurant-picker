package com.loginpage.application.service;

import com.loginpage.application.dto.Profile;
import com.loginpage.application.entity.EProfile;

import java.util.Optional;

public interface IProfileService extends IBaseService<Profile, EProfile, Long> {
    Optional<Profile> retrievedProfile(String username, String password);
    Profile changePassword(Profile profile, String oldPassword, String newPassword, boolean isLoggedIn);
    void deleteUser(Profile profile);
}
