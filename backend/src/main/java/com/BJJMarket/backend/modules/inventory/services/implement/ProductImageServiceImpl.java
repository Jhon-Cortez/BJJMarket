package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductImageRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductImageResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.ProductImage;
import com.BJJMarket.backend.modules.inventory.mappers.ProductImageMapper;
import com.BJJMarket.backend.modules.inventory.repository.ImageRepository;
import com.BJJMarket.backend.modules.inventory.repository.ProductImageRepository;
import com.BJJMarket.backend.modules.inventory.repository.ProductRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl extends AbstractCrudService<ProductImage, ProductImageRequestDto, ProductImageResponseDto, ProductImageRepository> {
    private final ProductImageMapper productImageMapper;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    public ProductImageServiceImpl(ProductImageRepository repository, ProductImageMapper productImageMapper,
                                    ProductRepository productRepository, ImageRepository imageRepository) {
        super(repository);
        this.productImageMapper = productImageMapper;
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    protected ProductImage toEntity(ProductImageRequestDto dto) {
        ProductImage productImage = productImageMapper.toEntity(dto);
        applyRelations(dto, productImage);
        return productImage;
    }

    @Override
    protected ProductImageResponseDto toResponse(ProductImage productImage) {
        return productImageMapper.toResponse(productImage);
    }

    @Override
    protected void merge(ProductImageRequestDto dto, ProductImage productImage) {
        productImageMapper.update(dto, productImage);
        applyRelations(dto, productImage);
    }

    private void applyRelations(ProductImageRequestDto dto, ProductImage productImage) {
        productImage.setProductId(productRepository.findById(dto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Not found")));
        productImage.setImageId(imageRepository.findById(dto.getImage())
                .orElseThrow(() -> new RuntimeException("Not found")));
    }
}
