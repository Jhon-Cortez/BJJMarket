/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.ProductBatch;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IProductBatch {
    public String Create(ProductBatch i);
    public List<ProductBatch> GetAll();
    public ProductBatch GetById(Integer productBatchId);
    public ProductBatch Update(Integer productBatchId);
    public ProductBatch PartialUpdate(Integer productBatchId);
    public boolean Delete(Integer productBatchId);
    public boolean LogicalDelete(Integer productBatchId);
}
