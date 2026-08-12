package com.BJJMarket.backend.modules.auth.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID>{
    List<UserRole> findByUser_UserId(UUID userId);
}
