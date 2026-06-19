package com.BJJMarket.backend.modules.inventory.controller;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductPriceRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductPriceResponseDto;
import com.BJJMarket.backend.modules.inventory.services.implement.ProductPriceServiceImpl;
import com.BJJMarket.backend.shared.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-prices")
public class ProductPriceController extends AbstractCrudController<ProductPriceResponseDto, ProductPriceRequestDto> {

    public ProductPriceController(ProductPriceServiceImpl service) {
        super(service);
    }
}
