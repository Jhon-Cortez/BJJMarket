/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.dto.response;

import com.BJJMarket.backend.modules.inventory.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import java.time.LocalDateTime;
import java.util.UUID;
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
public class ProductBatchResponseDto {
    @JsonView(Views.Detail.class)
    private UUID id;
    
    @JsonView(Views.Summary.class)
    private String batch_code;
    
    @JsonView(Views.Summary.class)
    private int quantity;
    
    @JsonView(Views.Summary.class)
    private LocalDateTime expiration_date;
    
    @JsonView(Views.Summary.class)
    private UUID batch_status_id;
    
    @JsonView(Views.Summary.class)
    private UUID product_id;

    @JsonView(Views.Detail.class)
    private String status;
}
