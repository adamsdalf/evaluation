package com.truper.evaluation.controller;

import com.truper.evaluation.domain.dto.ProductoDto;
import com.truper.evaluation.service.ProductoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("v1/productos")
public class ProductoController {

    private ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @PutMapping("{codigo}/precio")
    public ProductoDto update(@PathVariable String codigo,
                              @RequestParam BigDecimal precio){
        return productoService.update(codigo, precio);
    }
}
