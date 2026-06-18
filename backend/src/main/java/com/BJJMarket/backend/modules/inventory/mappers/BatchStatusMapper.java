/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.mappers;

import com.BJJMarket.backend.modules.inventory.dto.response.BatchStatusResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.BatchStatus;
import org.mapstruct.Mapper;

/**
 *
 * @author juan
 */

@Mapper(componentModel = "spring")
public interface BatchStatusMapper {
    BatchStatusResponseDto toResponse(BatchStatus batchstatus);
}
