/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.repository;

import com.BJJMarket.backend.modules.inventory.entity.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author juan
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {
    boolean existsByName(String name);
    boolean existsBySku(String sku);
}
