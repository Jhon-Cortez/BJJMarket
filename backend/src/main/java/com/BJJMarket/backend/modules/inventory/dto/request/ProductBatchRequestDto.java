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
public class ProductBatchRequestDto {
    @NotBlank(message = "El codigo es requerido")
    private String batch_code;
    @NotBlank(message = "La cantidad es requerida")
    private int quantity;
    @NotBlank(message = "La fecha es requerida")
    private LocalDateTime expiration_date;
    @NotBlank(message = "El estado del lote es requerido")
    private UUID batch_status_id;
    @NotBlank(message = "El producto es requerido")
    private UUID product_id;
}
