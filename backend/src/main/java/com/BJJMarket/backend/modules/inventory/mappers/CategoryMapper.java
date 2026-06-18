/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import com.BJJMarket.backend.modules.inventory.dto.response.CategoryResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Category;
import org.mapstruct.Mapper;

/**
 *
 * @author juan
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDto toResponse(Category category);
}
