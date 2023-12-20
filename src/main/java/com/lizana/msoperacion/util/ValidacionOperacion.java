package com.lizana.msoperacion.util;
import com.lizana.msoperacion.model.externoproduct.StatusResponse;
import com.lizana.msoperacion.model.dto.OperacionDto;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
public class ValidacionOperacion {

  public static void validacionOperacion(StatusResponse dto) {

/*    if (!(dto.getDetail().getLimitMaxCredito() == 2 )|| dto.getTipo()
        .equals("empresarial"))) {
      throw new ValidationException(HttpStatus.BAD_REQUEST.value(),
          "debe ser de tipo personal o empresarial",
          clientObject);
    }*/
    System.out.println("paso por aca");


  }











}








