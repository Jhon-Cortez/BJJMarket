package com.BJJMarket.backend.modules.auth.repository;

import com.BJJMarket.backend.modules.auth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID>{
    boolean existsByEmail(String email);
    Optional<Person> findByEmail(String email);
}
