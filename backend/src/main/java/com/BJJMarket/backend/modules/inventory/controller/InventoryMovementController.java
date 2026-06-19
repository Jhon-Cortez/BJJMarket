package com.BJJMarket.backend.modules.inventory.controller;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryMovementRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryMovementResponseDto;
import com.BJJMarket.backend.modules.inventory.services.implement.InventoryMovementServiceImpl;
import com.BJJMarket.backend.shared.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory-movements")
public class InventoryMovementController extends AbstractCrudController<InventoryMovementResponseDto, InventoryMovementRequestDto> {

    public InventoryMovementController(InventoryMovementServiceImpl service) {
        super(service);
    }
}
