package com.restaurant.picker.application.service.impl;

import com.restaurant.picker.application.mapper.impl.ProfileMapper;
import com.restaurant.picker.application.repo.IProfileRepo;
import com.restaurant.picker.application.dto.Profile;
import com.restaurant.picker.application.entity.EProfile;
import com.restaurant.picker.application.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService extends BaseService<Profile, EProfile, Long> implements IProfileService {

    private final IProfileRepo profileRepo;

    @Autowired
    public ProfileService(IProfileRepo profileRepo, ProfileMapper mapper){
        super(profileRepo,mapper);
        this.profileRepo = profileRepo;
    }

    @Override
    public Optional<Profile> retrievedProfile(String username, String password) {
        Optional<EProfile> retrievedEProfile = profileRepo.retrieveByUserName(username);
        return retrievedEProfile.map(mapper::toDto);
    }

    @Override
    public Profile changePassword(Profile profile, String oldPassword, String newPassword, boolean isLoggedIn){
        if(oldPassword.isEmpty() || newPassword.isEmpty()){
            throw new IllegalArgumentException("Please fill in old/new password.");
        }
        if(profile.getPassword() != oldPassword){
            throw new IllegalArgumentException("Existing password is incorrect.");
        }
        if(profile.getPassword() == newPassword){
            throw new IllegalArgumentException("New password is the same as the existing password.");
        }
        if(isLoggedIn){
            profile.setPassword(newPassword);
        }
        return save(profile);
    }

    @Override
    public void deleteUser(Profile profile){
        deleteById(profile.getId());
    }
}
