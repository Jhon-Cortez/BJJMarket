package com.BJJMarket.backend.modules.inventory.controller;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductBatchRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductBatchResponseDto;
import com.BJJMarket.backend.modules.inventory.services.implement.ProductBatchServiceImpl;
import com.BJJMarket.backend.shared.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-batches")
public class ProductBatchController extends AbstractCrudController<ProductBatchResponseDto, ProductBatchRequestDto> {

    public ProductBatchController(ProductBatchServiceImpl service) {
        super(service);
    }
}
