package com.BJJMarket.backend.modules.auth.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.Users;

public interface UserRepostory  extends JpaRepository<Users, UUID>{
    
}
