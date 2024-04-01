package com.loginpage.application.repo;

import com.loginpage.application.entity.EProfile;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface IProfileRepo extends IBaseRepo<EProfile, Long>{

    Optional<EProfile> retrieveByUserName(String username);

}
