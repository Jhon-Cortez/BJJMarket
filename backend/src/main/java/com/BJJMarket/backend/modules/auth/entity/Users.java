package com.BJJMarket.backend.modules.auth.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//Entidad que almacena y administra los usuarios del aplicativo
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "user_status_id", nullable = false)
    private UserStatus userStatus;

    @Column(name = "username", columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
    private String username;
    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;
}
