/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class InventoryRequestDto {
    @Min(value = 0, message = "La cantidad existente no puede ser negativa")
    private int available_stock;
    @Min(value = 0, message = "La cantidad dañada no puede ser negativa")
    private int damaged_stock;
    @Min(value = 0, message = "La cantidad caducada no puede ser negativa")
    private int expired_stock;
    @NotNull(message = "El producto es requerido")
    private UUID product_id;
}
