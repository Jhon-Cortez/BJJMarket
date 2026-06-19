/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.response;

import com.BJJMarket.backend.modules.inventory.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class InventoryMovementResponseDto {
    @JsonView(Views.Detail.class)
    private UUID id;
    
    @JsonView(Views.Summary.class)
    private int quantity;
    
    @JsonView(Views.Summary.class)
    private int previous_stock;
    
    @JsonView(Views.Summary.class)
    private String reasson;
    
    @JsonView(Views.Summary.class)
    private int new_stock;
    
    @JsonView(Views.Summary.class)
    private LocalDateTime created_at;
    
    @JsonView(Views.Summary.class)
    private UUID product_batch_id;
    
    @JsonView(Views.Summary.class)
    private UUID movement_type_id;
    
    @JsonView(Views.Detail.class)
    private String status;
}
