/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.BJJMarket.backend.modules.inventory.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 *
 * @author juan
 */
@Entity(name="inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @UuidGenerator
    @Column(name = "inventory_id")
    private UUID inventory_id;
    
    @Column(name = "available_stock", nullable = false)
    private int available_stock;
    
    @Column(name = "damaged_stock", nullable = false)
    private int damaged_stock;
    
    @Column(name = "expired_stock", nullable = false)
    private int expired_stock;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;
}
