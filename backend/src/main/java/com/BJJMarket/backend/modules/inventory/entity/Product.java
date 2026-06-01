package com.BJJMarket.backend.modules.inventory.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author juan
 */

@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @UuidGenerator
    @Column(name="product_id")
    private UUID product_id;

    @Column(name="name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name="description", nullable = false, length = 100)
    private String description;

    @Column(name="sku", nullable = false, unique = true, length = 50)
    private String sku;

    @Column(name="status", nullable = false, length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category_id;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = new ArrayList<>();

    @OneToMany(mappedBy = "product_id")
    private List<ProductBatch> productBatches = new ArrayList<>();
    
    @OneToMany(mappedBy = "product_id")
    private List<Inventory> inventory = new ArrayList<>();
    
    @OneToMany(mappedBy = "product_id")
    private List<ProductPrice> productPrice = new ArrayList<>();
}
