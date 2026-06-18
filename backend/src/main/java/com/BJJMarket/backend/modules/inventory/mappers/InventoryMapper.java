/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventoryMapper {
    Inventory toEntity(InventoryRequestDto dto);
    InventoryResponseDto toResponse(Inventory inventory);
}
