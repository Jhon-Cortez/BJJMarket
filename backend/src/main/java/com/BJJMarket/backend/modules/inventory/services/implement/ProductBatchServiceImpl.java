package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductBatchRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductBatchResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.ProductBatch;
import com.BJJMarket.backend.modules.inventory.mappers.ProductBatchMapper;
import com.BJJMarket.backend.modules.inventory.repository.ProductBatchRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProductBatchServiceImpl extends AbstractCrudService<ProductBatch, ProductBatchRequestDto, ProductBatchResponseDto, ProductBatchRepository> {
    private final ProductBatchMapper productBatchMapper;

    public ProductBatchServiceImpl(ProductBatchRepository repository, ProductBatchMapper productBatchMapper) {
        super(repository);
        this.productBatchMapper = productBatchMapper;
    }

    @Override
    protected ProductBatch toEntity(ProductBatchRequestDto dto) {
        return productBatchMapper.toEntity(dto);
    }

    @Override
    protected ProductBatchResponseDto toResponse(ProductBatch productBatch) {
        return productBatchMapper.toResponse(productBatch);
    }

    @Override
    protected void merge(ProductBatchRequestDto dto, ProductBatch productBatch) {
        productBatchMapper.update(dto, productBatch);
    }
}
