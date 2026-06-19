/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BJJMarket.backend.shared;

import java.util.List;

/**
 *
 * @author juan
 */
public interface ICrudService<ResponseDTO, RequestDTO, UUID> {
    List<ResponseDTO> findAll();

    ResponseDTO findById(UUID id);

    ResponseDTO save(RequestDTO dto);

    ResponseDTO update(UUID id, RequestDTO dto);
    
    ResponseDTO updatePartial(UUID id, RequestDTO dto);
    
    void delete(UUID id);
    
    void deletePartial(UUID id);
}
