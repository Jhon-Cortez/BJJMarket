package com.BJJMarket.backend.modules.inventory.entity;

import com.BJJMarket.backend.shared.BaseEntity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author juan
 */

@Entity
@Table(name="product_batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
public class ProductBatch extends BaseEntity {
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
    
    @OneToMany(mappedBy = "productBatch")
    private List<InventoryMovement> inventoryMovement = new ArrayList<>();
}
