package com.BJJMarket.backend.modules.inventory.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author juan
 */

@Entity(name="product_batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_batch_id")
    private UUID product_batch_id;

    @Column(name="batch_code", nullable = false, unique = true, length = 100)
    private String batch_code;

    @Column(name="quantity", nullable = false, unique = true)
    private int quantity;

    @Column(name="expiration_date", nullable = false)
    private LocalDateTime expiration_date;

    @ManyToOne
    @JoinColumn(name = "batch_status_id")
    private BatchStatus batch_status_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;
    
    @OneToMany(mappedBy = "product_batch")
    private List<InventoryMovement> inventoryMovement = new ArrayList<>();
}
