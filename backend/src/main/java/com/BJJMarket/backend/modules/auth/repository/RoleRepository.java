package com.BJJMarket.backend.modules.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    Optional<Role> findByName(String string);
    
}
