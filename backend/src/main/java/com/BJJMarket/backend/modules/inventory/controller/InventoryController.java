package com.BJJMarket.backend.modules.inventory.controller;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryResponseDto;
import com.BJJMarket.backend.modules.inventory.services.implement.InventoryServiceImpl;
import com.BJJMarket.backend.shared.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController extends AbstractCrudController<InventoryResponseDto, InventoryRequestDto> {

    public InventoryController(InventoryServiceImpl service) {
        super(service);
    }
}
