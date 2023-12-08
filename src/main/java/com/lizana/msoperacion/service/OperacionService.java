package com.lizana.msoperacion.service;

import com.lizana.msoperacion.model.dto.OperacionDto;
import com.lizana.msoperacion.model.dto.Status;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public interface OperacionService {

    Maybe<OperacionDto> saveProduct(OperacionDto operacionDto);

    Maybe<Status> deleteProduct(String idProduct);

    Maybe<OperacionDto> getProduct(String idProduct);

    Maybe<OperacionDto> updateProduct(OperacionDto operacionDto);


    Flowable<OperacionDto> getProductAll();
}
