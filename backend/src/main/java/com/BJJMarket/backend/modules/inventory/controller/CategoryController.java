package com.BJJMarket.backend.modules.inventory.controller;

import com.BJJMarket.backend.modules.inventory.dto.request.CategoryRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.CategoryResponseDto;
import com.BJJMarket.backend.modules.inventory.services.implement.CategoryServiceImpl;
import com.BJJMarket.backend.shared.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController extends AbstractCrudController<CategoryResponseDto, CategoryRequestDto> {

    public CategoryController(CategoryServiceImpl service) {
        super(service);
    }
}
