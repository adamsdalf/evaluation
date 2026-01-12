package com.truper.evaluation.mapper;

import com.truper.evaluation.domain.dto.ProductoDto;
import com.truper.evaluation.domain.entity.ProductoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoEntity toEntity(ProductoDto productoDto){
         ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setCodigo(productoDto.getCodigo());
        productoEntity.setDescripcion(productoDto.getDescripcion());
        productoEntity.setPrecio(productoDto.getPrecio());
        return productoEntity;
    }

    public ProductoDto toDto(ProductoEntity productoEntity){
        return ProductoDto.builder()
                .idProducto(productoEntity.getProductoId())
                .codigo(productoEntity.getCodigo())
                .descripcion(productoEntity.getDescripcion())
                .precio(productoEntity.getPrecio()).build();
    }
}
