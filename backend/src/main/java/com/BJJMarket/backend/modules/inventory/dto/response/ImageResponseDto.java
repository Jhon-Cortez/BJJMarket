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
public class ImageResponseDto {
    @JsonView(Views.Summary.class)
    private UUID image_id;
    
    @JsonView(Views.Summary.class)
    private String url;
}
