package com.BJJMarket.backend.modules.auth.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//Entidad o tabla pivot que relaciona usuarios con los roles, la relacion es de uno a muchos,(Un usuario puede tener varios roles)
@Entity
@Table(name = "user_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "user_role_id", nullable = false, updatable = false)
    private UUID userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}