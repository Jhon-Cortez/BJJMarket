/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.ProductImage;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IProductImage {
    public String Create(ProductImage pi);
    public List<ProductImage> GetAll();
    public ProductImage GetById(Integer productImageId);
    public ProductImage Update(Integer productImageId);
    public ProductImage PartialUpdate(Integer productImageId);
    public boolean Delete(Integer productImageId);
    public boolean LogicalDelete(Integer imageId);
}
