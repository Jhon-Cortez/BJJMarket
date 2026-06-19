package com.BJJMarket.backend.modules.inventory.repository;

import com.BJJMarket.backend.modules.inventory.entity.ProductBatch;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBatchRepository extends JpaRepository<ProductBatch, UUID> {

}
