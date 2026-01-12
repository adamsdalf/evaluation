package com.truper.evaluation.controller;

import com.truper.evaluation.domain.dto.OrdenRequest;
import com.truper.evaluation.domain.dto.OrdenResponse;
import com.truper.evaluation.service.OrdenService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("truper/api/v1/ordenes")
public class OrdenController {

    private OrdenService ordenService;

    public OrdenController(OrdenService ordenService){
        this.ordenService = ordenService;
    }

    @PostMapping
    public OrdenResponse save(@Valid @RequestBody OrdenRequest orden){
        return ordenService.save(orden);
    }

    @GetMapping("/{id}")
    public OrdenResponse find(@PathVariable Integer id){
        return null;
    }



}
