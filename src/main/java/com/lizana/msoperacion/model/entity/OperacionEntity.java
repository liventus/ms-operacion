package com.lizana.msoperacion.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "operacion")
public class OperacionEntity {

    @Id
    private String id;
    private String idSaldo;
    private String tipoDeOperacion;
    private Long monto;

}
