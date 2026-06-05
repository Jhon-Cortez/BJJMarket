/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.response;

import com.BJJMarket.backend.modules.inventory.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class ProductResponseDto {
    @JsonView(Views.Summary.class)
    private UUID product_id;
    
    @JsonView(Views.Summary.class)
    private String name;
    
    @JsonView(Views.Summary.class)
    private String description;
    
    @JsonView(Views.Summary.class)
    private String sku;
    
    @JsonView(Views.Summary.class)
    private String status;
    
    @JsonView(Views.Summary.class)
    private UUID category_id;
}
