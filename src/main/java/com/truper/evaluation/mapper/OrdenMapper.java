package com.truper.evaluation.mapper;

import com.truper.evaluation.domain.dto.OrdenResponse;
import com.truper.evaluation.domain.entity.OrdenEntity;
import org.springframework.stereotype.Component;

@Component
public class OrdenMapper {
    public OrdenResponse toResponse(OrdenEntity entity){
        return OrdenResponse.builder()
                .ordenId(entity.getOrdenId())
                .total(entity.getTotal())
                .fecha(entity.getFecha()).build();
    }
}
