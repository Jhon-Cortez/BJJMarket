/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.Inventory;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IInventory {
    public String Create(Inventory i);
    public List<Inventory> GetAll();
    public Inventory GetById(Integer inventoryId);
    public Inventory Update(Integer inventoryId);
    public Inventory PartialUpdate(Integer inventoryId);
    public boolean Delete(Integer inventoryId);
    public boolean LogicalDelete(Integer inventoryId);
}
