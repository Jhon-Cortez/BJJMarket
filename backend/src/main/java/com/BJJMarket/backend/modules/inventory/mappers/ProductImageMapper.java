/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductImageRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductImageResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.ProductImage;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "imageId", ignore = true)
    @Mapping(target = "id", ignore = true)
    ProductImage toEntity(ProductImageRequestDto dto);
    
    @Mapping(target = "product_id", source = "productId.id")
    @Mapping(target = "image_id", source = "imageId.id")
    ProductImageResponseDto toResponse(ProductImage productImage);

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "imageId", ignore = true)
    @Mapping(target = "id", ignore = true)
    void update(ProductImageRequestDto dto, @MappingTarget ProductImage productImage);
}
