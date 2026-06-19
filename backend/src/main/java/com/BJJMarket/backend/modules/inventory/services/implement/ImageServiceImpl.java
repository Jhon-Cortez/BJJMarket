/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ImageRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ImageResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Image;
import com.BJJMarket.backend.modules.inventory.mappers.ImageMapper;
import com.BJJMarket.backend.modules.inventory.repository.ImageRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

/**
 *
 * @author juan
 */
@Service
public class ImageServiceImpl extends AbstractCrudService<Image, ImageRequestDto, ImageResponseDto, ImageRepository> {
    private final ImageMapper imageMapper;
    
    public ImageServiceImpl(ImageRepository repository, ImageMapper imageMapper) {
        super(repository);
        this.imageMapper = imageMapper;
    }

    @Override
    protected Image toEntity(ImageRequestDto dto) {
        return imageMapper.toEntity(dto);
    }

    @Override
    protected ImageResponseDto toResponse(Image image) {
        return imageMapper.toResponse(image);
    }

    @Override
    protected void merge(ImageRequestDto dto, Image image) {
        imageMapper.update(dto, image);
    }
}