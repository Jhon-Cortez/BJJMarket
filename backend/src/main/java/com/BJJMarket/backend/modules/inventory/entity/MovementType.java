/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author juan
 */

@Entity(name="movement_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementType {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "movement_type_id")
    private UUID movement_type_id;
    
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    
    @Column(name = "description", nullable = false, length = 50)
    private int description;
    
    @OneToMany(mappedBy = "movementType")
    private List<InventoryMovement> inventoryMovement = new ArrayList<>();
}
