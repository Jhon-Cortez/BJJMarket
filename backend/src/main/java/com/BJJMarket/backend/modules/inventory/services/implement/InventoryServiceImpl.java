package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Inventory;
import com.BJJMarket.backend.modules.inventory.mappers.InventoryMapper;
import com.BJJMarket.backend.modules.inventory.repository.InventoryRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl extends AbstractCrudService<Inventory, InventoryRequestDto, InventoryResponseDto, InventoryRepository> {
    private final InventoryMapper inventoryMapper;

    public InventoryServiceImpl(InventoryRepository repository, InventoryMapper inventoryMapper) {
        super(repository);
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    protected Inventory toEntity(InventoryRequestDto dto) {
        return inventoryMapper.toEntity(dto);
    }

    @Override
    protected InventoryResponseDto toResponse(Inventory inventory) {
        return inventoryMapper.toResponse(inventory);
    }

    @Override
    protected void merge(InventoryRequestDto dto, Inventory inventory) {
        inventoryMapper.update(dto, inventory);
    }
}
