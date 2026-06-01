package com.BJJMarket.backend.modules.auth.entity;

import com.BJJMarket.backend.shared.audit.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Entidad donde estara almacenada la lista de roles
@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role{
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "name", columnDefinition = "VARCHAR(60)", nullable = false, unique = true)
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(100)")
    private String description;
}
