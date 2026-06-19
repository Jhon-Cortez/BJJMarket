package com.BJJMarket.backend.modules.inventory.controller;

import com.BJJMarket.backend.modules.inventory.dto.request.ImageRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ImageResponseDto;
import com.BJJMarket.backend.modules.inventory.services.implement.ImageServiceImpl;
import com.BJJMarket.backend.shared.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController extends AbstractCrudController<ImageResponseDto, ImageRequestDto> {

    public ImageController(ImageServiceImpl service) {
        super(service);
    }
}
