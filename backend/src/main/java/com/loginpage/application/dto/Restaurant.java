package com.loginpage.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Restaurant implements BaseDto<Long> {
    @Setter(value = AccessLevel.PRIVATE)
    private String instanceOf = this.getClass().getSimpleName();
    private Long id;
    private String name;
    private Boolean activeStatus;
    private String createdBy;
    private LocalDateTime createdTime;
    private String modifiedBy;
    private LocalDateTime modifiedTime;
}
