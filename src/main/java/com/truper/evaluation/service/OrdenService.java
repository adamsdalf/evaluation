package com.truper.evaluation.service;

import com.truper.evaluation.domain.dto.OrdenRequest;
import com.truper.evaluation.domain.dto.OrdenResponse;
import com.truper.evaluation.domain.entity.OrdenEntity;
import com.truper.evaluation.domain.entity.SucursalEntity;
import com.truper.evaluation.exception.NotFoundException;
import com.truper.evaluation.mapper.OrdenMapper;
import com.truper.evaluation.mapper.ProductoMapper;
import com.truper.evaluation.mapper.SucursalMapper;
import com.truper.evaluation.repository.OrdenRepository;
import com.truper.evaluation.repository.SucursalRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class OrdenService {

    /**
     * ordenRepository.
     */
    private OrdenRepository ordenRepository;

    /**
     * sucursalRepository.
     */
    private SucursalRepository sucursalRepository;

    /**
     * Clase para mapear Producto.
     */
    private ProductoMapper productoMapper;

    /**
     * Clase para mapear Sucursal.
     */
    private SucursalMapper sucursalMapper;

    /**
     * Clase para mapear Orden.
     */
    private OrdenMapper ordenMapper;

    public OrdenService(OrdenRepository ordenRepository,
                        SucursalRepository sucursalRepository,
                        ProductoMapper productoMapper,
                        SucursalMapper sucursalMapper,
                        OrdenMapper ordenMapper){
        this.ordenRepository = ordenRepository;
        this.sucursalRepository = sucursalRepository;
        this.productoMapper = productoMapper;
        this.sucursalMapper = sucursalMapper;
        this.ordenMapper = ordenMapper;
    }

    /**
     * Guarda una Orden
     * @param request
     * @return
     */
    @Transactional
    public OrdenResponse save (OrdenRequest request){
        log.info("save request: {}", request);
        SucursalEntity sucursal= Optional.ofNullable(request.getSucursalId()).flatMap(
                sucursalRepository::findById
        ).orElseThrow(()-> new NotFoundException("NotFound SucursalId:"+ request.getSucursalId()));

        OrdenEntity ordenEntity = new OrdenEntity();
        ordenEntity.setFecha( new Date());
        ordenEntity.setTotal(request.getTotal());
        ordenEntity.setSucursal(sucursal);
        Optional.ofNullable(request.getProductos())
                .orElse(Collections.emptyList()).forEach(
                p->
                    ordenEntity.addProducto(productoMapper.toEntity(p))
        );
        OrdenEntity ordenSaved = ordenRepository.save(ordenEntity);
        return getOrdenResponse(ordenSaved);
    }

    /**
     * Castea un OrdenEntity a OrdenResponse.
     * @param orden
     * @return OrdenResponse
     */
    private OrdenResponse getOrdenResponse(OrdenEntity orden) {
        OrdenResponse response = ordenMapper.toResponse(orden);
        response.setSucursal(sucursalMapper.toDto(orden.getSucursal()));
        orden.getProductos().forEach(
                p->response.getProductos().add(productoMapper.toDto(p)));
        return response;
    }

    /**
     * Busca orden apartir de idOrden.
     * @param idOrden
     * @return
     */
    @Transactional
    public OrdenResponse find(Integer idOrden){
        return Optional.ofNullable(idOrden).flatMap(ordenRepository::findById).map(
                this::getOrdenResponse
        ).orElseThrow(()-> new NotFoundException("NotFound idOrden:"+ idOrden));
    }

}
