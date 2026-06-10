package com.BJJMarket.backend.modules.inventory.entity;

import com.BJJMarket.backend.shared.BaseEntity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author juan
 */

@Entity
@Table(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product extends BaseEntity {
    @Column(name="name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name="description", nullable = false, length = 100)
    private String description;

    @Column(name="sku", nullable = false, unique = true, length = 50)
    private String sku;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category categoryId;

    @OneToMany(mappedBy = "productId")
    private List<ProductImage> productImages = new ArrayList<>();

    @OneToMany(mappedBy = "productId")
    private List<ProductBatch> productBatches = new ArrayList<>();
    
    @OneToMany(mappedBy = "productId")
    private List<Inventory> inventory = new ArrayList<>();
    
    @OneToMany(mappedBy = "productId")
    private List<ProductPrice> productPrice = new ArrayList<>();
}
