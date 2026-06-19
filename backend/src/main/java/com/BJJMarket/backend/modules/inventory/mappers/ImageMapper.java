/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.BJJMarket.backend.modules.inventory.dto.request.ImageRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ImageResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Image;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring")
public interface ImageMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productImages", ignore = true)
    Image toEntity(ImageRequestDto dto);
    
    ImageResponseDto toResponse(Image image);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productImages", ignore = true)
    void update(ImageRequestDto dto, @MappingTarget Image image);
}
