/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Inventory;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventoryMapper {
    Inventory toEntity(InventoryRequestDto dto);
    InventoryResponseDto toResponse(Inventory inventory);

    @Mapping(target = "productId", ignore = true)
    void update(InventoryRequestDto dto, @MappingTarget Inventory inventory);
}
