package com.lizana.msoperacion.util;




import com.lizana.msoperacion.model.dto.OperacionDto;
import com.lizana.msoperacion.model.entity.OperacionEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


@NoArgsConstructor
public class OperacionUtil {

    public static OperacionDto entityToDto(OperacionEntity entity) {
        OperacionDto dto= new OperacionDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static OperacionEntity dtoToEntity(OperacionDto productDto) {
        OperacionEntity entity = new OperacionEntity();
        BeanUtils.copyProperties(productDto, entity);
        return entity;
    }
}
