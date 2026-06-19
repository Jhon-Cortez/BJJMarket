package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductImageRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductImageResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.ProductImage;
import com.BJJMarket.backend.modules.inventory.mappers.ProductImageMapper;
import com.BJJMarket.backend.modules.inventory.repository.ProductImageRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl extends AbstractCrudService<ProductImage, ProductImageRequestDto, ProductImageResponseDto, ProductImageRepository> {
    private final ProductImageMapper productImageMapper;

    public ProductImageServiceImpl(ProductImageRepository repository, ProductImageMapper productImageMapper) {
        super(repository);
        this.productImageMapper = productImageMapper;
    }

    @Override
    protected ProductImage toEntity(ProductImageRequestDto dto) {
        return productImageMapper.toEntity(dto);
    }

    @Override
    protected ProductImageResponseDto toResponse(ProductImage productImage) {
        return productImageMapper.toResponse(productImage);
    }

    @Override
    protected void merge(ProductImageRequestDto dto, ProductImage productImage) {
        productImageMapper.update(dto, productImage);
    }
}
