package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductPriceRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductPriceResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.ProductPrice;
import com.BJJMarket.backend.modules.inventory.mappers.ProductPriceMapper;
import com.BJJMarket.backend.modules.inventory.repository.ProductPriceRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceServiceImpl extends AbstractCrudService<ProductPrice, ProductPriceRequestDto, ProductPriceResponseDto, ProductPriceRepository> {
    private final ProductPriceMapper productPriceMapper;

    public ProductPriceServiceImpl(ProductPriceRepository repository, ProductPriceMapper productPriceMapper) {
        super(repository);
        this.productPriceMapper = productPriceMapper;
    }

    @Override
    protected ProductPrice toEntity(ProductPriceRequestDto dto) {
        return productPriceMapper.toEntity(dto);
    }

    @Override
    protected ProductPriceResponseDto toResponse(ProductPrice productPrice) {
        return productPriceMapper.toResponse(productPrice);
    }

    @Override
    protected void merge(ProductPriceRequestDto dto, ProductPrice productPrice) {
        productPriceMapper.update(dto, productPrice);
    }
}
