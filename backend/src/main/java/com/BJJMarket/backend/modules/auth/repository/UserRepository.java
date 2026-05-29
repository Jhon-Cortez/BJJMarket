package com.BJJMarket.backend.modules.auth.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.Users;

public interface UserRepository  extends JpaRepository<Users, UUID>{
    Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);
    
}
