/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.MovementType;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IMovementType {
    public String Create(MovementType mt);
    public List<MovementType> GetAll();
    public MovementType GetById(Integer movementTypeId);
    public MovementType Update(Integer movementTypeId);
    public MovementType PartialUpdate(Integer movementTypeId);
    public boolean Delete(Integer movementTypeId);
    public boolean LogicalDelete(Integer movementTypeId);
}
