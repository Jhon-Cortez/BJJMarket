/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "La cantidad es requerida")
    private int quantity;
    @NotBlank(message = "Las existencias anteriores son requeridas")
    private int previous_stock;
    @NotBlank(message = "El motivo es requerido")
    private String reasson;
    @NotBlank(message = "La cantidad nueva es requerida")
    private int new_stock;
    @NotBlank(message = "La fecha de creacion es requerida")
    private LocalDateTime created_at;
    @NotBlank(message = "El lote es requerido")
    private UUID product_batch_id;
    @NotBlank(message = "El tipo de movimiento es requerido")
    private UUID movement_type_id;
}
