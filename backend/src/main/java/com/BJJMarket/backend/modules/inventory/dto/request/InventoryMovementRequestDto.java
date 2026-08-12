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
public class InventoryMovementRequestDto {
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private int quantity;
    @Min(value = 0, message = "Las existencias anteriores no pueden ser negativas")
    private int previous_stock;
    @NotBlank(message = "El motivo es requerido")
    private String reasson;
    @Min(value = 0, message = "La cantidad nueva no puede ser negativa")
    private int new_stock;
    private LocalDateTime created_at;
    @NotNull(message = "El lote es requerido")
    private UUID product_batch_id;
    @NotNull(message = "El tipo de movimiento es requerido")
    private UUID movement_type_id;
}
