package com.BJJMarket.backend.modules.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserStatus {
    @Id
    @Column(name = "user_status_id")
    private Integer userStatusId;

    @Column(name = "name", columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(60)")
    private String description;
}
