package com.truper.evaluation.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SucursalDto {

    private Integer sucursalId;

    private String nombre;

}
