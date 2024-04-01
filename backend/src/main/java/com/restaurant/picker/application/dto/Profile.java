package com.restaurant.picker.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile implements BaseDto<Long>{
    private Long id;
    @Setter(value = AccessLevel.PRIVATE)
    private String instanceOf = this.getClass().getSimpleName();
    private String name;
    private String userName;
    private String password;
}
