package com.BJJMarket.backend.modules.auth.service.implement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.BJJMarket.backend.modules.auth.dto.request.LoginRequest;
import com.BJJMarket.backend.modules.auth.dto.request.RegisterRequest;
import com.BJJMarket.backend.modules.auth.dto.response.LoginResponse;
import com.BJJMarket.backend.modules.auth.entity.Person;
import com.BJJMarket.backend.modules.auth.entity.Role;
import com.BJJMarket.backend.modules.auth.entity.UserRole;
import com.BJJMarket.backend.modules.auth.entity.UserStatus;
import com.BJJMarket.backend.modules.auth.entity.Users;
import com.BJJMarket.backend.modules.auth.exception.EmailAlreadyExistException;
import com.BJJMarket.backend.modules.auth.exception.UserAlreadyExistException;
import com.BJJMarket.backend.modules.auth.repository.PersonRepository;
import com.BJJMarket.backend.modules.auth.repository.RoleRepository;
import com.BJJMarket.backend.modules.auth.repository.UserRepository;
import com.BJJMarket.backend.modules.auth.repository.UserRoleRepository;
import com.BJJMarket.backend.modules.auth.repository.UserStatusRepository;
import com.BJJMarket.backend.modules.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PersonRepository personRepository;
    private final UserStatusRepository userStatusRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public void register(RegisterRequest request) {
        //Valida si ya existe un Username igual
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistException(request.getUsername());
        }
        //VAlida si existe un correo igual
        if (personRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistException(request.getEmail());
        }
        //Crea la persona con los datos puestos
        Person person = new Person();

        person.setName(request.getName());
        person.setLastName(request.getLastName());
        person.setBirthDate(request.getBirthDate());
        person.setPhone(request.getPhone());
        person.setEmail(request.getEmail());

        //Se guardan los datos y se da el estatus(Active o activo)
        person = personRepository.save(person);
        UserStatus status = userStatusRepository
        .findByName("ACTIVE")
        .orElseThrow(() ->  new RuntimeException("Estado ACTIVE no encontrado"));

        //Se crea un usuario con los datos de person
        Users user = new Users();

        user.setPerson(person);
        user.setUserStatus(status);
        //Se agrega el username y la contraseña para guardarlo
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        //Se guardan los datos y se da el rol(Customer o cliente)
        user = userRepository.save(user);
        Role role = roleRepository.findByName("CUSTOMER")
        .orElseThrow(() -> new RuntimeException());
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        //Se guardan los datos
        userRoleRepository.save(userRole);
    }
    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }
    
}
