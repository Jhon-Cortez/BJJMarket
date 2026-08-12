/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author juan
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatchRequestDto {
    @NotBlank(message = "El codigo es requerido")
    private String batch_code;
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private int quantity;
    @NotNull(message = "La fecha es requerida")
    private LocalDateTime expiration_date;
    @NotNull(message = "El estado del lote es requerido")
    private UUID batch_status_id;
    @NotNull(message = "El producto es requerido")
    private UUID product_id;
}
