package com.BJJMarket.backend.modules.inventory.entity;

import com.BJJMarket.backend.shared.BaseEntity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Image extends BaseEntity {
    @Column(name="url", nullable = false, unique = true, length = 255)
    private String url;

    @OneToMany(mappedBy = "imageId")
    private List<ProductImage> productImages = new ArrayList<>();
}