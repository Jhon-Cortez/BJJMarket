package com.BJJMarket.backend.modules.inventory.controller;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductResponseDto;
import com.BJJMarket.backend.modules.inventory.services.implement.ProductServiceImpl;
import com.BJJMarket.backend.shared.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends AbstractCrudController<ProductResponseDto, ProductRequestDto> {

    public ProductController(ProductServiceImpl service) {
        super(service);
    }
}
