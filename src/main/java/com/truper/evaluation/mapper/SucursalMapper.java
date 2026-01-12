package com.truper.evaluation.mapper;

import com.truper.evaluation.domain.dto.SucursalDto;
import com.truper.evaluation.domain.entity.SucursalEntity;
import org.springframework.stereotype.Component;

@Component
public class SucursalMapper {
    public SucursalDto toDto(SucursalEntity entity){
     return SucursalDto.builder().sucursalId(entity.getSucursalId())
             .nombre(entity.getNombre()).build();
    }
}
