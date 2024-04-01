package com.loginpage.application.controller;

import com.loginpage.application.dto.BaseDto;
import com.loginpage.application.entity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.net.URISyntaxException;

public interface IBaseController<D extends BaseDto<I>, E extends BaseEntity<I>, I extends Serializable> {

    ResponseEntity<D> fetch(@PathVariable(value = "id") I id, HttpServletRequest request);
    ResponseEntity<D> save(@RequestBody D d, HttpServletRequest request) throws URISyntaxException;
    ResponseEntity<D> update(@RequestBody D d, HttpServletRequest request) throws URISyntaxException;
    void delete(@PathVariable(value = "id") I id);
}
