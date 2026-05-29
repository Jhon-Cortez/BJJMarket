/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.InventoryMovement;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IInventoryMovement {
    public String Create(InventoryMovement c);
    public List<InventoryMovement> GetAll();
    public InventoryMovement GetById(Integer inventoryMovementId);
    public InventoryMovement Update(Integer inventoryMovementId);
    public InventoryMovement PartialUpdate(Integer inventoryMovementId);
    public boolean Delete(Integer inventoryMovementId);
    public boolean LogicalDelete(Integer inventoryMovementId);
}
