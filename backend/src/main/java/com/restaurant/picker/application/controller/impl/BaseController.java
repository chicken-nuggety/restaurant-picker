package com.restaurant.picker.application.controller.impl;

import com.restaurant.picker.application.controller.IBaseController;
import com.restaurant.picker.application.dto.BaseDto;
import com.restaurant.picker.application.service.IBaseService;
import com.restaurant.picker.application.entity.BaseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

public class BaseController<D extends BaseDto<I>, E extends BaseEntity<I>, I extends Serializable> implements IBaseController<D, E, I> {
    protected final IBaseService<D, E, I> service;

    public BaseController(IBaseService<D, E, I> service){
        this.service = service;
    }


    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @Override
    public ResponseEntity<D> fetch(@PathVariable(value = "id") I id, HttpServletRequest request) {
        Optional<D> dto = service.fetch(id);
        if(dto.isPresent()){
            final HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<>(dto.get(),headers,HttpStatus.OK);
        } else{
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    @Override
    public ResponseEntity<D> save(@RequestBody D d, HttpServletRequest request) throws URISyntaxException {
        final D savedD = service.save(d);
        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(String.format("%s/%s", request.getRequestURL(),savedD.getId())));
        return new ResponseEntity<>(savedD, headers, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @Override
    public ResponseEntity<D> update(@RequestBody D d, HttpServletRequest request) throws URISyntaxException {
        if(Objects.isNull(d.getId())){
            throw new URISyntaxException(String.valueOf(d.getId()),"Cannot update without ID");
        }
        final HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(service.save(d), headers, HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Override
    public @ResponseBody void delete(@PathVariable(value = "id") I id){
        service.deleteById(id);
    }


}
