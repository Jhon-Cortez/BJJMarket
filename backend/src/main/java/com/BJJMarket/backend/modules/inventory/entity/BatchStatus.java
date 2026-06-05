package com.BJJMarket.backend.modules.inventory.entity;

import com.BJJMarket.backend.shared.BaseEntity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name="batch_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
public class BatchStatus extends BaseEntity {
    @Column(name="name", nullable = false, unique = true, length = 20)
    private String name;

    @Column(name="description", nullable = false, length = 50)
    private String description;

    @OneToMany(mappedBy = "batch_status_id")
    private List<ProductBatch> batchEstatus = new ArrayList<>();
}