package com.BJJMarket.backend.modules.inventory.repository;

import com.BJJMarket.backend.modules.inventory.entity.BatchStatus;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchStatusRepository extends JpaRepository<BatchStatus, UUID> {

}
