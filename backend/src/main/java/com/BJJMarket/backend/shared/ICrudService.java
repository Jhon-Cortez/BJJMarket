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
public interface ICrudService<ResponseDTO, RequestDTO, ID> {
    List<ResponseDTO> findAll();

    ResponseDTO findById(ID id);

    ResponseDTO save(RequestDTO dto);

    void delete(ID id);
}
