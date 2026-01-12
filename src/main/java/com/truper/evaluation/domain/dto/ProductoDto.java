package com.truper.evaluation.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    @NotBlank
    private String codigo;

    @NotBlank
    private String descripcion;

    @NotNull
    private BigDecimal precio;

}
