package com.restaurant.picker.application.mapper.impl;

import com.restaurant.picker.application.dto.Profile;
import com.restaurant.picker.application.entity.EProfile;
import com.restaurant.picker.application.mapper.BaseMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ProfileMapper implements BaseMapper<EProfile, Profile> {

    public EProfile toEntity(Profile dto) {
        final EProfile entity = new EProfile();

        if (dto != null) {
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setUserName(dto.getUserName());
            entity.setPassword(dto.getPassword());
        }
        return entity;
    }

    public Profile toDto(EProfile entity) {
        final Profile dto = new Profile();

        if (entity != null) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUserName(entity.getUserName());
            dto.setPassword(entity.getPassword());
        }
        return dto;
    }

}
