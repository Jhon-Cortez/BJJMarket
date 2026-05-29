package com.BJJMarket.backend.modules.auth.entity;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "user_id",columnDefinition = "VARCHAR(36)", updatable = false, nullable = false, unique = true)
    private UUID user_id;

    @Column(name = "person_id", columnDefinition = "VARCHAR(36)", updatable = false, nullable = false, unique = true)
    private UUID person_id;
    @Column(name = "user_status_id")
    private int user_status_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}
