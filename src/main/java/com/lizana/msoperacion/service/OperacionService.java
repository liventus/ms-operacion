package com.lizana.msoperacion.service;

import com.lizana.msoperacion.model.dto.OperacionDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OperacionService {

    Mono<OperacionDto> saveProduct(OperacionDto operacionDto);


    Mono<OperacionDto> getProduct(String idProduct);


    Flux<OperacionDto> getProductAll();
}
