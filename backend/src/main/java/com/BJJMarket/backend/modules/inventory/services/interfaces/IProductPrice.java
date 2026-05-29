/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.ProductPrice;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IProductPrice {
    public String Create(ProductPrice i);
    public List<ProductPrice> GetAll();
    public ProductPrice GetById(Integer productPriceId);
    public ProductPrice Update(Integer productPriceId);
    public ProductPrice PartialUpdate(Integer productPriceId);
    public boolean Delete(Integer productPriceId);
    public boolean LogicalDelete(Integer productPriceId);
}
