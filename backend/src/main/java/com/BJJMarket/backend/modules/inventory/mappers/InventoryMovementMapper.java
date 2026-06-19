/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryMovementRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryMovementResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.InventoryMovement;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring")
public interface InventoryMovementMapper {
    @Mapping(target = "productBatchId", ignore= true)
    @Mapping(target = "movementTypeId", ignore= true)
    @Mapping(target = "id", ignore = true)
    InventoryMovement toEntity(InventoryMovementRequestDto dto);
            
    @Mapping(target = "product_batch_id", source="productBatchId.id")
    @Mapping(target = "movement_type_id", source="movementTypeId.id")
    InventoryMovementResponseDto toResponse(InventoryMovement inventoryMovement);
    
    @Mapping(target = "productBatchId", ignore= true)
    @Mapping(target = "movementTypeId", ignore= true)
    @Mapping(target = "id", ignore = true)
    void update(InventoryMovementRequestDto dto, @MappingTarget InventoryMovement inventoryMovement);
}
