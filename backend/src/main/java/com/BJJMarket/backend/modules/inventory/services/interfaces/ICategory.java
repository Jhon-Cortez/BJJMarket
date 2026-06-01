/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.Category;
import java.util.List;

/**
 *
 * @author juan
 */
public interface ICategory {
    public String Create(Category c);
    public List<Category> GetAll();
    public Category GetById(Integer categoryId);
    public Category Update(Integer categoryId);
    public Category PartialUpdate(Integer categoryId);
    public boolean Delete(Integer categoryId);
    public boolean LogicalDelete(Integer categoryId);
}
