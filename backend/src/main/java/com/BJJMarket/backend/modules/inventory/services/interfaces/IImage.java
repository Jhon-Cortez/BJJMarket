/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.interfaces;

import com.BJJMarket.backend.modules.inventory.entity.Image;
import java.util.List;

/**
 *
 * @author juan
 */
public interface IImage {
    public String Create(Image i);
    public List<Image> GetAll();
    public Image GetById(Integer imageId);
    public Image Update(Integer imageId);
    public Image PartialUpdate(Integer imageId);
    public boolean Delete(Integer imageId);
    public boolean LogicalDelete(Integer imageId);
}