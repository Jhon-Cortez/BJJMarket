package com.BJJMarket.backend.modules.inventory.repository;

import com.BJJMarket.backend.modules.inventory.entity.Image;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, UUID> {

}
