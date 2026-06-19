/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message="La cantidad existente es requerida")
    private int available_stock;
    @NotBlank(message="La cantidad dañada es requerida")
    private int damaged_stock;
    @NotBlank(message="La cantidad caducada es requeirda")
    private int expired_stock;
    @NotBlank(message="El producto es requeirdo")
    private UUID product_id;
}
