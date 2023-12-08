package com.lizana.msoperacion.repository;


import com.lizana.msoperacion.model.entity.OperacionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacionRepository extends ReactiveMongoRepository<OperacionEntity, String> {

    // Mono<ProductEntity> findByTipoDeDocumentoAndNumeroDeDocumento(String tipoDeDocumento, String numeroDeDocumento);
}
