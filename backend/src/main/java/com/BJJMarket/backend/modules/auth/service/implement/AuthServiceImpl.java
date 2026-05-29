package com.BJJMarket.backend.modules.auth.service.implement;

import org.springframework.stereotype.Service;

import com.BJJMarket.backend.modules.auth.dto.request.LoginRequest;
import com.BJJMarket.backend.modules.auth.dto.request.RegisterRequest;
import com.BJJMarket.backend.modules.auth.dto.response.LoginResponse;
import com.BJJMarket.backend.modules.auth.entity.Person;
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

    private final UserRepository userRepostory;
    private final RoleRepository roleRepository;
    private final PersonRepository personRepository;
    private final UserStatusRepository userStatusRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public void register(RegisterRequest request) {
        if (userRepostory.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistException(request.getUsername());
        }
        if (personRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistException(request.getEmail());
        }
        System.out.println("Registro completado");

        Person person = new Person();

        person.setName(request.getName());
        person.setLastName(request.getLastName());
        person.setBirthDate(request.getBirthDate());
        person.setPhone(request.getPhone());
        person.setEmail(request.getEmail());

        person = personRepository.save(person);
        UserStatus status = userStatusRepository
        .findByName("ACTIVE")
        .orElseThrow();

        Users user = new Users();

        user.setPerson(person);
        user.setUserStatus(status);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        user = userRepostory.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }
    
}
