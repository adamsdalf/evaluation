package com.truper.evaluation.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenResponse {

    /**
     * ordenId.
     */
    private Integer ordenId;
    /**
     * sucursal.
     */
    private SucursalDto sucursal;

    /**
     * fecha.
     */
    private Date fecha;

    /**
     * total.
     */
    private BigDecimal total;

    @Builder.Default
    private List<ProductoDto> productos = new ArrayList<>();
}
