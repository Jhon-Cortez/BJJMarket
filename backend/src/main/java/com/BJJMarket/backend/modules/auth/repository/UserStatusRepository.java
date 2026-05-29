package com.BJJMarket.backend.modules.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.UserStatus;

public interface UserStatusRepository extends JpaRepository<UserStatus, Integer>{
    Optional<UserStatus> findByName(String name);
}
