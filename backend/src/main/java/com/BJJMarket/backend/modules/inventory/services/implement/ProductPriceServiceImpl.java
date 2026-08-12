package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductPriceRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductPriceResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Product;
import com.BJJMarket.backend.modules.inventory.entity.ProductPrice;
import com.BJJMarket.backend.modules.inventory.mappers.ProductPriceMapper;
import com.BJJMarket.backend.modules.inventory.repository.ProductPriceRepository;
import com.BJJMarket.backend.modules.inventory.repository.ProductRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceServiceImpl extends AbstractCrudService<ProductPrice, ProductPriceRequestDto, ProductPriceResponseDto, ProductPriceRepository> {
    private final ProductPriceMapper productPriceMapper;
    private final ProductRepository productRepository;

    public ProductPriceServiceImpl(ProductPriceRepository repository, ProductPriceMapper productPriceMapper,
                                    ProductRepository productRepository) {
        super(repository);
        this.productPriceMapper = productPriceMapper;
        this.productRepository = productRepository;
    }

    @Override
    protected ProductPrice toEntity(ProductPriceRequestDto dto) {
        ProductPrice productPrice = productPriceMapper.toEntity(dto);
        productPrice.setProductId(resolveProduct(dto.getProduct_id()));
        return productPrice;
    }

    @Override
    protected ProductPriceResponseDto toResponse(ProductPrice productPrice) {
        return productPriceMapper.toResponse(productPrice);
    }

    @Override
    protected void merge(ProductPriceRequestDto dto, ProductPrice productPrice) {
        productPriceMapper.update(dto, productPrice);
        productPrice.setProductId(resolveProduct(dto.getProduct_id()));
    }

    private Product resolveProduct(java.util.UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }
}
