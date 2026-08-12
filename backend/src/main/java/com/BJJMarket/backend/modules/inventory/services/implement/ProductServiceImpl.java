/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BJJMarket.backend.modules.inventory.services.implement;

import com.BJJMarket.backend.modules.inventory.dto.request.ProductRequestDto;
import com.BJJMarket.backend.modules.inventory.dto.response.ProductResponseDto;
import com.BJJMarket.backend.modules.inventory.entity.Category;
import com.BJJMarket.backend.modules.inventory.entity.Product;
import com.BJJMarket.backend.modules.inventory.mappers.ProductMapper;
import com.BJJMarket.backend.modules.inventory.repository.CategoryRepository;
import com.BJJMarket.backend.modules.inventory.repository.ProductRepository;
import com.BJJMarket.backend.shared.AbstractCrudService;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author juan
 */

@Service
public class ProductServiceImpl extends AbstractCrudService<Product, ProductRequestDto, ProductResponseDto, ProductRepository> {
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository repository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        super(repository);
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected Product toEntity(ProductRequestDto dto) {
        Product product = productMapper.toEntity(dto);
        product.setCategoryId(resolveCategory(dto.getCategory_id()));
        return product;
    }

    @Override
    protected ProductResponseDto toResponse(Product product) {
        return productMapper.toResponse(product);
    }

    @Override
    protected void merge(ProductRequestDto dto, Product product) {
        productMapper.update(dto, product);
        product.setCategoryId(resolveCategory(dto.getCategory_id()));
    }

    private Category resolveCategory(UUID categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public ProductResponseDto save(ProductRequestDto dto) {
        List<Product> product = repository.findAll();
    
        for (Product p : product) {
            if (p.getName().equals(dto.getName())) {
                throw new RuntimeException("El nombre " + dto.getName() + " ya existe.");
            }
            if (p.getSku().equals(dto.getSku())) {
                throw new RuntimeException("El SKU " + dto.getSku() + " ya existe.");
            }
        }
    
        return super.save(dto);
    }
}
