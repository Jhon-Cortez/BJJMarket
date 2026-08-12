package com.BJJMarket.backend.modules.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDto {
    @NotBlank(message = "El nombre es requerido")
    private String name;
    @NotBlank(message = "La descripcion es requerida")
    private String description;
}
