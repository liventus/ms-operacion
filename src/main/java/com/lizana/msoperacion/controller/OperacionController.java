package com.lizana.msoperacion.controller;


import com.lizana.msoperacion.model.dto.OperacionDto;
import com.lizana.msoperacion.service.OperacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(OperacionController.OPERATIONS)
public class OperacionController {


    public static final String OPERATIONS = "/operations";

    @Autowired
    OperacionService operacionService;

    @PostMapping(produces = {"application/json"})
    public Mono<OperacionDto> create(@RequestBody OperacionDto requestBody) {
        return operacionService.saveProduct(requestBody);
    }


    @RequestMapping("/all")
    public Flux<OperacionDto> findAll() {
        return operacionService.getProductAll();
    }

    @GetMapping
    public Mono<OperacionDto> buscarPor(@RequestHeader String productId) {
        return operacionService.getProduct(productId);
    }









}
