package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryMovementRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryMovementResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.InventoryMovement;
import com.BJJMarket.backend.modules.inventory.mappers.InventoryMovementMapper;
import com.BJJMarket.backend.modules.inventory.repository.InventoryMovementRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class InventoryMovementServiceImpl extends AbstractCrudService<InventoryMovement, InventoryMovementRequestDto, InventoryMovementResponseDto, InventoryMovementRepository> {
    private final InventoryMovementMapper inventoryMovementMapper;

    public InventoryMovementServiceImpl(InventoryMovementRepository repository, InventoryMovementMapper inventoryMovementMapper) {
        super(repository);
        this.inventoryMovementMapper = inventoryMovementMapper;
    }

    @Override
    protected InventoryMovement toEntity(InventoryMovementRequestDto dto) {
        return inventoryMovementMapper.toEntity(dto);
    }

    @Override
    protected InventoryMovementResponseDto toResponse(InventoryMovement inventoryMovement) {
        return inventoryMovementMapper.toResponse(inventoryMovement);
    }

    @Override
    protected void merge(InventoryMovementRequestDto dto, InventoryMovement inventoryMovement) {
        inventoryMovementMapper.update(dto, inventoryMovement);
    }
}
