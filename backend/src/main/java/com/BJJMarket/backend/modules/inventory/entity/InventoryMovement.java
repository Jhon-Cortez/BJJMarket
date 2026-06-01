/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.entity;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author juan
 */

@Entity(name="inventory_movement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryMovement {
    @Id
    @UuidGenerator
    @Column(name = "inventory_movement_id")
    private UUID category_movement_id;
    
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
}
