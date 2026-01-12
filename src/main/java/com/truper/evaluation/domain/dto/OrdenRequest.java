package com.truper.evaluation.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenRequest  implements Serializable {

    @NotNull
    private Integer sucursalId;

    @NotNull
    private BigDecimal total;

    @NotNull
    @Valid
    private List<ProductoDto> productos;

}
