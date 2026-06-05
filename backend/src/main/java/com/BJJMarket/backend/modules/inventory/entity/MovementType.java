/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.entity;
import com.BJJMarket.backend.shared.BaseEntity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="movement_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
public class MovementType extends BaseEntity {
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    
    @OneToMany(mappedBy = "movementType")
    private List<InventoryMovement> inventoryMovement = new ArrayList<>();
}
