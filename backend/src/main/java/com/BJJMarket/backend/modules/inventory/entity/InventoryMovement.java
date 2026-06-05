/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.entity;
import com.BJJMarket.backend.shared.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author juan
 */

@Entity
@Table(name="inventory_movement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
public class InventoryMovement extends BaseEntity {
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "previous_stock", nullable = false)
    private int previous_stock;
    
    @Column(name = "reasson", nullable = false, length = 100)
    private String reasson;
    
    @Column(name = "new_stock", nullable = false)
    private int new_stock;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name="product_batch_id")
    private ProductBatch productBatch;
    
    @ManyToOne
    @JoinColumn(name="movement_type_id")
    private MovementType movementType;
    
    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }
}
