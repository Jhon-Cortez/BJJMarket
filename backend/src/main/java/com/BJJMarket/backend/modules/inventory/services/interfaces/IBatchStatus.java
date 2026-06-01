/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.BatchStatus;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IBatchStatus {
    public String Create(BatchStatus b);
    public List<BatchStatus> GetAll();
    public BatchStatus GetById(Integer batchStatusId);
    public BatchStatus Update(Integer batchStatusId);
    public BatchStatus PartialUpdate(Integer batchStatusId);
    public boolean Delete(Integer batchStatusId);
    public boolean LogicalDelete(Integer batchStatusId);
}
