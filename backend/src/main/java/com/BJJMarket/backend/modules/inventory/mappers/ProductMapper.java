/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Product;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productImages", ignore = true)
    @Mapping(target = "productBatches", ignore = true)
    @Mapping(target = "inventory", ignore = true)
    @Mapping(target = "productPrice", ignore = true)
    Product toEntity(ProductRequestDto dto);
    
    @Mapping(target = "category_id", source = "categoryId.id")
    ProductResponseDto toResponse(Product product);

    @Mapping(target = "categoryId", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productImages", ignore = true)
    @Mapping(target = "productBatches", ignore = true)
    @Mapping(target = "inventory", ignore = true)
    @Mapping(target = "productPrice", ignore = true)
    void update(ProductRequestDto dto, @MappingTarget Product product);
}
