package com.loginpage.application.service.impl;

import com.loginpage.application.mapper.impl.ProfileMapper;
import com.loginpage.application.repo.IProfileRepo;
import com.loginpage.application.dto.Profile;
import com.loginpage.application.entity.EProfile;
import com.loginpage.application.service.ILoginService;
import com.loginpage.application.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService extends BaseService<Profile, EProfile, Long> implements ILoginService {
    private final IProfileRepo profileRepo;
    private final IProfileService profileService;

    @Autowired
    public LoginService(IProfileRepo profileRepo, ProfileMapper mapper, IProfileService profileService){
        super(profileRepo,mapper);
        this.profileRepo = profileRepo;
        this.profileService = profileService;
    }

    @Override
    public Optional<Profile> login(String username, String password){
        Optional<Profile> profile = profileService.retrievedProfile(username, password);
        if(profile.isEmpty()){
            throw new IllegalArgumentException("User does not exist");
        }
        if(profile.get().getPassword() != password){
            throw new IllegalArgumentException("Incorrect Password");
        }
        return profile;
    }

    @Override
    public Profile register(Profile profile){
        if(!profile.getPassword().isEmpty()){
            throw new IllegalArgumentException("Field: Password must be filled.");
        }
        if(!profile.getName().isEmpty()){
            throw new IllegalArgumentException("Field: Name must be filled.");
        }
        if(!profile.getUserName().isEmpty()){
            throw new IllegalArgumentException("Field: Username must be filled.");
        }
        return save(profile);
    }

}
