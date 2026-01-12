package com.truper.evaluation.service;

import com.truper.evaluation.domain.dto.ProductoDto;
import com.truper.evaluation.exception.NotFoundException;
import com.truper.evaluation.mapper.ProductoMapper;
import com.truper.evaluation.repository.ProductoRepositiry;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductoService {

    private ProductoRepositiry productoRepositiry;

    private ProductoMapper productoMapper;

    public ProductoService(ProductoRepositiry productoRepositiry, ProductoMapper productoMapper){
        this.productoRepositiry = productoRepositiry;
        this.productoMapper = productoMapper;
    }

    /**
     * Metodo para actualizar precio de un producto
     * @param codigo
     * @param precio
     * @return productoDto.
     */
    @Transactional
   public ProductoDto update(String codigo, BigDecimal precio){
      return Optional.ofNullable(codigo).flatMap(
               productoRepositiry::findByCodigo
       ).map( p->{
                    p.setPrecio(precio);
                    return productoMapper.toDto(productoRepositiry.save(p));
              }
               ).orElseThrow(()-> new NotFoundException("NotFound codigo: "+codigo));
   }

}
