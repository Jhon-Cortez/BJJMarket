/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.entity;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movement_type_id")
    private UUID movement_type_id;
    
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    
    @Column(name = "description", nullable = false, length = 50)
    private int description;
    
    @OneToMany(mappedBy = "movement_type")
    private List<InventoryMovement> inventoryMovement = new ArrayList<>();
}
