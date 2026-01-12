package com.truper.evaluation.service;

import com.truper.evaluation.domain.dto.OrdenRequest;
import com.truper.evaluation.domain.dto.OrdenResponse;
import com.truper.evaluation.domain.entity.OrdenEntity;
import com.truper.evaluation.domain.entity.SucursalEntity;
import com.truper.evaluation.exception.NotFoundException;
import com.truper.evaluation.repository.OrdenRepository;
import com.truper.evaluation.repository.SucursalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrdenService {

    /**
     * ordenRepository.
     */
    private OrdenRepository ordenRepository;

    private SucursalRepository sucursalRepository;

    public OrdenService(OrdenRepository ordenRepository, SucursalRepository sucursalRepository){
        this.ordenRepository = ordenRepository;
        this.sucursalRepository = sucursalRepository;
    }


    public OrdenResponse save (OrdenRequest request){
        log.info("save request: {}", request);
        SucursalEntity sucursal= Optional.ofNullable(request.getSucursalId()).flatMap(
                sucursalRepository::findById
        ).orElseThrow(()-> new NotFoundException("NotFound SucursalId:"+ request.getSucursalId()));

        log.info("sucursal:{}", sucursal);

    //TODO: temp
        return null;
    }

}
