package com.lizana.msoperacion.util;


import com.lizana.msoperacion.model.dto.OperacionDto;
import com.lizana.msoperacion.model.dto.StatusResponse;

public class ValidationException extends RuntimeException {


    private StatusResponse statusResponse;

    public ValidationException(int codigo, String descripcion, OperacionDto clientObject) {

        this.statusResponse = new StatusResponse();
        this.statusResponse.setCode(codigo);
        this.statusResponse.setDescription(descripcion);
        this.statusResponse.setDetail(clientObject);
    }

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }
}
