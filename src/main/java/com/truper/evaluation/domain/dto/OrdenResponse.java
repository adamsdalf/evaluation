package com.truper.evaluation.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenResponse {

    private Integer ordenId;

    private SurcursalDto sucursal;

    private Date fecha;

    private BigDecimal total;


}
