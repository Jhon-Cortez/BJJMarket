/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.BJJMarket.backend.modules.inventory.entity;
import com.BJJMarket.backend.shared.BaseEntity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author juan
 */
@Entity
@Table(name="inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
public class Inventory extends BaseEntity {
    @Column(name = "available_stock", nullable = false)
    private int available_stock;
    
    @Column(name = "damaged_stock", nullable = false)
    private int damaged_stock;
    
    @Column(name = "expired_stock", nullable = false)
    private int expired_stock;
    
    // @Column(name = "updated_at", nullable = false)
    // private LocalDateTime updated_at;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;
}
