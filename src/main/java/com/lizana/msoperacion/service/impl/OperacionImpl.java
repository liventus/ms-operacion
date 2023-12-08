package com.lizana.msoperacion.service.impl;

import com.lizana.msoperacion.model.dto.OperacionDto;
import com.lizana.msoperacion.model.dto.Status;
import com.lizana.msoperacion.model.entity.OperacionEntity;
import com.lizana.msoperacion.repository.OperacionRepository;
import com.lizana.msoperacion.service.OperacionService;
import com.lizana.msoperacion.util.OperacionUtil;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class OperacionImpl implements OperacionService {

    @Autowired
    private OperacionRepository productRepository;


    @Override
    public Maybe<OperacionDto> saveProduct(OperacionDto operacionDto) {
        //guarda el producto
        Mono<OperacionEntity> savedEntity = productRepository.save(OperacionUtil.dtoToEntity(operacionDto));
        return Maybe.fromPublisher(savedEntity.map(OperacionUtil::entityToDto));
    }

    @Override
    public Maybe<Status> deleteProduct(String idProduct) {
        return Maybe.fromPublisher(
                productRepository.findById(idProduct)
                        .flatMap(product -> {
                            if (product != null) {
                                return productRepository.deleteById(product.getId())
                                        .then(Mono.just(new Status("asd", "a")));
                            } else {
                                return Mono.empty();
                            }
                        })
                        .switchIfEmpty(Mono.just(new Status("NOT_FOUND", "Product not found")))
        );

    }

    @Override
    public Maybe<OperacionDto> getProduct(String idProduct) {
        //extrae el producto
        Mono<OperacionEntity> para = productRepository.findById(idProduct);
        return Maybe.fromPublisher(para.map(OperacionUtil::entityToDto));
    }

    @Override
    public Maybe<OperacionDto> updateProduct(OperacionDto operacionDto) {
        Mono<OperacionEntity> updateEntity = productRepository.save(OperacionUtil.dtoToEntity(operacionDto));
        return Maybe.fromPublisher(updateEntity.map(OperacionUtil::entityToDto));
    }

    @Override
    public Flowable<OperacionDto> getProductAll() {
        return Flowable
                .fromPublisher(productRepository.findAll().map(OperacionUtil::entityToDto));
    }

}
