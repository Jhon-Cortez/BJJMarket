package com.BJJMarket.backend.modules.auth.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.BJJMarket.backend.modules.auth.entity.Role;
import com.BJJMarket.backend.modules.auth.entity.UserStatus;
import com.BJJMarket.backend.modules.auth.repository.RoleRepository;
import com.BJJMarket.backend.modules.auth.repository.UserStatusRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CatalogDataLoader implements CommandLineRunner{

    private final UserStatusRepository userStatusRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userStatusRepository.count() == 0) {
            userStatusRepository.save(new UserStatus(1,"ACTIVE","Usuario activo"));
            userStatusRepository.save(new UserStatus(1,"INACTIVE","Usuario inactivo"));
        }
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(1,"ADMIN","Administrador"));
            roleRepository.save(new Role(2,"EMPLOYE","Empleado"));
            roleRepository.save(new Role(3,"CUSTOMER","Clientte"));
        }
    }

}
