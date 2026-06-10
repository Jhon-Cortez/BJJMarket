/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductPriceRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductPriceResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.ProductPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring")
public interface ProductPriceMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productId", ignore = true)
    ProductPrice toEntity(ProductPriceRequestDto dto);
    
    @Mapping(target = "product_id", source = "productId.id")
    ProductPriceResponseDto toResponse(ProductPrice productPrice);
}
