package com.BJJMarket.backend.modules.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
