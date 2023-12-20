package com.lizana.msoperacion.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperacionDto {

    private String id;
    private String idSaldo;
    private String tipoDeOperacion;
    private Long monto;


}
