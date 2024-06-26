package com.restaurant.picker.application.dto;

import java.io.Serializable;

public interface BaseDto<I extends Serializable> {

    I getId();

    void setId(I id);

    String getInstanceOf();
}
