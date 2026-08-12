package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryMovementRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryMovementResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.InventoryMovement;
import com.BJJMarket.backend.modules.inventory.mappers.InventoryMovementMapper;
import com.BJJMarket.backend.modules.inventory.repository.InventoryMovementRepository;
import com.BJJMarket.backend.modules.inventory.repository.MovementTypeRepository;
import com.BJJMarket.backend.modules.inventory.repository.ProductBatchRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class InventoryMovementServiceImpl extends AbstractCrudService<InventoryMovement, InventoryMovementRequestDto, InventoryMovementResponseDto, InventoryMovementRepository> {
    private final InventoryMovementMapper inventoryMovementMapper;
    private final ProductBatchRepository productBatchRepository;
    private final MovementTypeRepository movementTypeRepository;

    public InventoryMovementServiceImpl(InventoryMovementRepository repository, InventoryMovementMapper inventoryMovementMapper,
                                         ProductBatchRepository productBatchRepository, MovementTypeRepository movementTypeRepository) {
        super(repository);
        this.inventoryMovementMapper = inventoryMovementMapper;
        this.productBatchRepository = productBatchRepository;
        this.movementTypeRepository = movementTypeRepository;
    }

    @Override
    protected InventoryMovement toEntity(InventoryMovementRequestDto dto) {
        InventoryMovement inventoryMovement = inventoryMovementMapper.toEntity(dto);
        applyRelations(dto, inventoryMovement);
        return inventoryMovement;
    }

    @Override
    protected InventoryMovementResponseDto toResponse(InventoryMovement inventoryMovement) {
        return inventoryMovementMapper.toResponse(inventoryMovement);
    }

    @Override
    protected void merge(InventoryMovementRequestDto dto, InventoryMovement inventoryMovement) {
        inventoryMovementMapper.update(dto, inventoryMovement);
        applyRelations(dto, inventoryMovement);
    }

    private void applyRelations(InventoryMovementRequestDto dto, InventoryMovement inventoryMovement) {
        inventoryMovement.setProductBatchId(productBatchRepository.findById(dto.getProduct_batch_id())
                .orElseThrow(() -> new RuntimeException("Not found")));
        inventoryMovement.setMovementTypeId(movementTypeRepository.findById(dto.getMovement_type_id())
                .orElseThrow(() -> new RuntimeException("Not found")));
    }
}
