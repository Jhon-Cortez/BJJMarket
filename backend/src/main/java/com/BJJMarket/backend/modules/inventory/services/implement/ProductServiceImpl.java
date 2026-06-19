/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Product;
import com.BJJMarket.backend.modules.inventory.mappers.ProductMapper;
import com.BJJMarket.backend.modules.inventory.repository.ProductRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import org.springframework.stereotype.Service;

/**
 *
 * @author juan
 */

@Service
public class ProductServiceImpl extends AbstractCrudService<Product, ProductRequestDto, ProductResponseDto, ProductRepository> {
    private final ProductMapper productMapper;
    
    public ProductServiceImpl(ProductRepository repository, ProductMapper productMapper) {
        super(repository);
        this.productMapper = productMapper;
    }

    @Override
    protected Product toEntity(ProductRequestDto dto) {
        return productMapper.toEntity(dto);
    }

    @Override
    protected ProductResponseDto toResponse(Product product) {
        return productMapper.toResponse(product);
    }

    @Override
    protected void merge(ProductRequestDto dto, Product product) {
        productMapper.update(dto, product);
    }
}
