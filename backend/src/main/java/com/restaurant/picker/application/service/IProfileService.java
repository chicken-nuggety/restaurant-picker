package com.restaurant.picker.application.service;

import com.restaurant.picker.application.dto.Profile;
import com.restaurant.picker.application.entity.EProfile;

import java.util.Optional;

public interface IProfileService extends IBaseService<Profile, EProfile, Long> {
    Optional<Profile> retrievedProfile(String username, String password);
    Profile changePassword(Profile profile, String oldPassword, String newPassword, boolean isLoggedIn);
    void deleteUser(Profile profile);
}
