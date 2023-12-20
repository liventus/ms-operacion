package com.lizana.msoperacion.service;

import com.lizana.msoperacion.model.dto.OperacionDto;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface OperacionService {

    Maybe<OperacionDto> saveProduct(OperacionDto operacionDto);


    Maybe<OperacionDto> getProduct(String idProduct);


    Flowable<OperacionDto> getProductAll();
}
