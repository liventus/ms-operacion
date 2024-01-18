package com.lizana.msoperacion.service.impl;
import com.lizana.msoperacion.model.dto.OperacionDto;
import com.lizana.msoperacion.model.entity.OperacionEntity;
import com.lizana.msoperacion.repository.OperacionRepository;
import com.lizana.msoperacion.service.OperacionService;
import com.lizana.msoperacion.util.OperacionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




@Service
public class OperacionImpl implements OperacionService {

    @Autowired
    private OperacionRepository productRepository;


    @Override
    public Mono<OperacionDto> saveProduct(OperacionDto operacionDto) {
        //guarda el producto
        Mono<OperacionEntity> savedEntity = productRepository.save(OperacionUtil.dtoToEntity(operacionDto));
        return savedEntity.map(OperacionUtil::entityToDto);
    }




    @Override
    public Mono<OperacionDto> getProduct(String idProduct) {
        //extrae el producto
        Mono<OperacionEntity> para = productRepository.findById(idProduct);
        return para.map(OperacionUtil::entityToDto);
    }



    @Override
    public Flux<OperacionDto> getProductAll() {
        return productRepository.findAll().map(OperacionUtil::entityToDto);
    }

}
