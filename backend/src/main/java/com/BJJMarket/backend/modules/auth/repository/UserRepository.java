package com.BJJMarket.backend.modules.auth.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BJJMarket.backend.modules.auth.entity.Users;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<Users, UUID>{
    Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("""
        SELECT u
        FROM  Users u
        WHERE
        u.username like LOWER(CONCAT('%', :filter, '%')) OR
        u.person.email like LOWER(CONCAT('%', :filter, '%') )
    """)
    //Se usa el concat para que el jpql lo lea correctamente
    List<Users> findAll(String filter);
}
