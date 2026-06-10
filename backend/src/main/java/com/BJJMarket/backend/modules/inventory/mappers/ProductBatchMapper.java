/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductBatchRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductBatchResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.ProductBatch;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring")
public interface ProductBatchMapper {
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "batchStatusId", ignore = true)
    @Mapping(target = "inventoryMovement", ignore = true)
    @Mapping(target = "id", ignore = true)
    ProductBatch toEntity(ProductBatchRequestDto dto);
    
    @Mapping(target = "product_id", source="productId.id")
    @Mapping(target = "batch_status_id", source="batchStatusId.id")
    ProductBatchResponseDto toResponse(ProductBatch productBatch);
}
