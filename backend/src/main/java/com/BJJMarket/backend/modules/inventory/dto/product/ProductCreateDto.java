/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author juan
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {
    private String name;
    private String description;
    private String sku;
    private String status;
    private int category_id;
}
