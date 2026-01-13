package com.truper.evaluation.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdatePasswordRequest {
    @NotBlank
    private String actualPassword;

    @NotBlank
    @Size(min = 6, max = 72) // ajusta política
    private String nuevoPassword;
}
