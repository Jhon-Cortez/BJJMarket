package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductBatchRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductBatchResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.BatchStatus;
import com.BJJMarket.backend.modules.inventory.entity.Product;
import com.BJJMarket.backend.modules.inventory.entity.ProductBatch;
import com.BJJMarket.backend.modules.inventory.mappers.ProductBatchMapper;
import com.BJJMarket.backend.modules.inventory.repository.BatchStatusRepository;
import com.BJJMarket.backend.modules.inventory.repository.ProductBatchRepository;
import com.BJJMarket.backend.modules.inventory.repository.ProductRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProductBatchServiceImpl extends AbstractCrudService<ProductBatch, ProductBatchRequestDto, ProductBatchResponseDto, ProductBatchRepository> {
    private final ProductBatchMapper productBatchMapper;
    private final ProductRepository productRepository;
    private final BatchStatusRepository batchStatusRepository;

    public ProductBatchServiceImpl(ProductBatchRepository repository, ProductBatchMapper productBatchMapper,
                                    ProductRepository productRepository, BatchStatusRepository batchStatusRepository) {
        super(repository);
        this.productBatchMapper = productBatchMapper;
        this.productRepository = productRepository;
        this.batchStatusRepository = batchStatusRepository;
    }

    @Override
    protected ProductBatch toEntity(ProductBatchRequestDto dto) {
        ProductBatch productBatch = productBatchMapper.toEntity(dto);
        applyRelations(dto, productBatch);
        return productBatch;
    }

    @Override
    protected ProductBatchResponseDto toResponse(ProductBatch productBatch) {
        return productBatchMapper.toResponse(productBatch);
    }

    @Override
    protected void merge(ProductBatchRequestDto dto, ProductBatch productBatch) {
        productBatchMapper.update(dto, productBatch);
        applyRelations(dto, productBatch);
    }

    private void applyRelations(ProductBatchRequestDto dto, ProductBatch productBatch) {
        Product product = productRepository.findById(dto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Not found"));
        BatchStatus batchStatus = batchStatusRepository.findById(dto.getBatch_status_id())
                .orElseThrow(() -> new RuntimeException("Not found"));
        productBatch.setProductId(product);
        productBatch.setBatchStatusId(batchStatus);
    }
}
