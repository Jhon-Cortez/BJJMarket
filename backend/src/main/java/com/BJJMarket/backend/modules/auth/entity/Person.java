package com.BJJMarket.backend.modules.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

import com.BJJMarket.backend.shared.audit.Auditable;

//Entidad donde se guarda y administra los datos de cada persona registrada
@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Auditable{
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "person_id", updatable = false, nullable = false)
    private UUID personId;
    
    @Column(name = "name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;
    @Column(name = "last_name", columnDefinition = "VARCHAR(60)",nullable = false)
    private String lastName;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "phone", columnDefinition = "VARCHAR(20)", nullable = true)
    private String phone;
    @Column(name = "email", columnDefinition = "VARCHAR(255)",nullable = false, unique = true)
    private String email;
}
