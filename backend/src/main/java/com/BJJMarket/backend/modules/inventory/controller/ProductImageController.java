package com.BJJMarket.backend.modules.inventory.controller;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductImageRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductImageResponseDto;
import com.BJJMarket.backend.modules.inventory.services.implement.ProductImageServiceImpl;
import com.BJJMarket.backend.shared.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-images")
public class ProductImageController extends AbstractCrudController<ProductImageResponseDto, ProductImageRequestDto> {

    public ProductImageController(ProductImageServiceImpl service) {
        super(service);
    }
}
