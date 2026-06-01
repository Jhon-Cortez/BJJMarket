package com.BJJMarket.backend.modules.inventory.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

@Entity(name="batch_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchStatus {
    @Id
    @UuidGenerator
    @Column(name="batch_status_id")
    private UUID batch_status_id;

    @Column(name="name", nullable = false, unique = true, length = 20)
    private String name;

    @Column(name="description", nullable = false, length = 50)
    private String description;

    @OneToMany(mappedBy = "batch_status_id")
    private List<ProductBatch> batchEstatus = new ArrayList<>();
}