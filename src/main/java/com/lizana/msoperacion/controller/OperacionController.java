package com.lizana.msoperacion.controller;


import com.lizana.msoperacion.model.dto.OperacionDto;
import com.lizana.msoperacion.service.OperacionService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(OperacionController.OPERATIONS)
public class OperacionController {


    public static final String OPERATIONS = "/operations";

    @Autowired
    OperacionService operacionService;

    @PostMapping(produces = {"application/json"})
    public Maybe<OperacionDto> create(@RequestBody OperacionDto requestBody) {
        return operacionService.saveProduct(requestBody);
    }


    @RequestMapping("/all")
    public Flowable<OperacionDto> findAll() {
        return operacionService.getProductAll();
    }

    @GetMapping
    public Maybe<OperacionDto> buscarPor(@RequestHeader String productId) {
        return operacionService.getProduct(productId);
    }









}
