package com.BJJMarket.backend.modules.inventory.services.implement;

import org.springframework.stereotype.Service;

import com.BJJMarket.backend.modules.inventory.dto.request.CategoryRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.CategoryResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Category;
import com.BJJMarket.backend.modules.inventory.mappers.CategoryMapper;
import com.BJJMarket.backend.modules.inventory.repository.CategoryRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;

@Service
public class CategoryServiceImpl extends AbstractCrudService<Category, CategoryRequestDto, CategoryResponseDto, CategoryRepository> {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper categoryMapper) {
        super(repository);
        this.categoryMapper = categoryMapper;
    }

    @Override
    protected Category toEntity(CategoryRequestDto dto) {
        return categoryMapper.toEntity(dto);
    }

    @Override
    protected CategoryResponseDto toResponse(Category category) {
        return categoryMapper.toResponse(category);
    }

    @Override
    protected void merge(CategoryRequestDto dto, Category category) {
        categoryMapper.update(dto, category);
    }
}
