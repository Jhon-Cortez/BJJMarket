package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.InventoryRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.InventoryResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Inventory;
import com.BJJMarket.backend.modules.inventory.mappers.InventoryMapper;
import com.BJJMarket.backend.modules.inventory.repository.InventoryRepository;
import com.BJJMarket.backend.modules.inventory.repository.ProductRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl extends AbstractCrudService<Inventory, InventoryRequestDto, InventoryResponseDto, InventoryRepository> {
    private final InventoryMapper inventoryMapper;
    private final ProductRepository productRepository;

    public InventoryServiceImpl(InventoryRepository repository, InventoryMapper inventoryMapper, ProductRepository productRepository) {
        super(repository);
        this.inventoryMapper = inventoryMapper;
        this.productRepository = productRepository;
    }

    @Override
    protected Inventory toEntity(InventoryRequestDto dto) {
        Inventory inventory = inventoryMapper.toEntity(dto);
        applyRelations(dto, inventory);
        return inventory;
    }

    @Override
    protected InventoryResponseDto toResponse(Inventory inventory) {
        return inventoryMapper.toResponse(inventory);
    }

    @Override
    protected void merge(InventoryRequestDto dto, Inventory inventory) {
        inventoryMapper.update(dto, inventory);
        applyRelations(dto, inventory);
    }

    private void applyRelations(InventoryRequestDto dto, Inventory inventory) {
        inventory.setProductId(productRepository.findById(dto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Not found")));
        inventory.setUpdated_at(LocalDateTime.now());
    }

    @Override
    public InventoryResponseDto save(InventoryRequestDto dto) {
        List<Inventory> inventory = repository.findAll();

        for (Inventory i : inventory) {
            if (i.getProductId().getId().equals(dto.getProduct_id())) {
                throw new RuntimeException("Ya existe inventario para el producto " + dto.getProduct_id());
            }
        }

        return super.save(dto);
    }
}
