package com.BJJMarket.backend.modules.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.Person;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID>{
    boolean existsByEmail(String email);
}
