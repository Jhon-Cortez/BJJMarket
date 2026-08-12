package com.BJJMarket.backend.modules.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.BJJMarket.backend.modules.inventory.dto.request.CategoryRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.CategoryResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category toEntity(CategoryRequestDto dto);

    CategoryResponseDto toResponse(Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    void update(CategoryRequestDto dto, @MappingTarget Category category);
}
