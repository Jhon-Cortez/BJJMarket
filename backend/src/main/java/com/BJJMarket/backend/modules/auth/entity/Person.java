package com.BJJMarket.backend.modules.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;


@Entity
public class Person {
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "person_id", columnDefinition = "VARCHAR(36", updatable = false, nullable = false, unique = true)
    private UUID person_id;
    
    @Column(name = "name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;
    @Column(name = "last_name", columnDefinition = "VARCHAR(60)",nullable = false)
    private String last_name;
    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birth_date;
    @Column(name = "phone", columnDefinition = "VARCHAR(20)", nullable = true)
    private String phone;
    @Column(name = "email", columnDefinition = "VARCHAR(100)",nullable = false, unique = true)
    private String email;
}
