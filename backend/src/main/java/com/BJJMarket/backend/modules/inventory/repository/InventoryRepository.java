package com.BJJMarket.backend.modules.inventory.repository;

import com.BJJMarket.backend.modules.inventory.entity.Inventory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

}
