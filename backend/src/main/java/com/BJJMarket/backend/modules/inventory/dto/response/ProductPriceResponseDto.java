/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.response;

import com.BJJMarket.backend.modules.inventory.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import java.math.BigDecimal;
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
public class ProductPriceResponseDto {
    @JsonView(Views.Summary.class)
    private UUID product_price_id;
    
    @JsonView(Views.Summary.class)
    private BigDecimal price;
    
    @JsonView(Views.Summary.class)
    private boolean active;
    
    @JsonView(Views.Summary.class)
    private UUID product_id;
}
