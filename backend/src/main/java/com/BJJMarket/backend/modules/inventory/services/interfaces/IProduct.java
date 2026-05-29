/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.Product;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IProduct {
    // Crear un elemento - POST
    public String Create(Product p);
    
    // Listar los registros - GET
    public List<Product> GetAll();
    
    // Buscar por un id - GET
    public Product GetById(Integer productId);
    
    // Actualiar todos los campos de un registro - PUT
    public Product Update(Integer productId);
    
    // Actualiar un campo de un registro - PATCH
    public Product PartialUpdate(Integer productId);
    
    // Eliminar por completo un registro en la db
    public boolean Delete(Integer productId);
    
    // Deshabiliar un registro temporalmente
    public boolean LogicalDelete(Integer productId);
}
