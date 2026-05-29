package com.BJJMarket.backend.modules.auth.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.UserRole;

public interface UserROleRepository extends JpaRepository<UserRole, UUID>{

}
