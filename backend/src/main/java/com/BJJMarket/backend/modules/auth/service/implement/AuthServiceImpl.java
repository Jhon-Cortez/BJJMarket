package com.BJJMarket.backend.modules.auth.service.implement;

import com.BJJMarket.backend.modules.auth.dto.response.UserResponse;
import com.BJJMarket.backend.modules.auth.entity.*;
import com.BJJMarket.backend.modules.auth.exception.RoleNotFoundExcetion;
import com.BJJMarket.backend.modules.auth.exception.UserAlreadyExistException;
import com.BJJMarket.backend.modules.auth.exception.UserNotFoundExecption;
import com.BJJMarket.backend.modules.auth.exception.UserStatusNotFoundException;
import com.BJJMarket.backend.modules.auth.mapper.UserMapper;
import com.BJJMarket.backend.modules.auth.repository.PersonRepository;
import com.BJJMarket.backend.modules.auth.repository.RoleRepository;
import com.BJJMarket.backend.modules.auth.repository.UserStatusRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.BJJMarket.backend.modules.auth.dto.request.LoginRequest;
import com.BJJMarket.backend.modules.auth.dto.request.RegisterRequest;
import com.BJJMarket.backend.modules.auth.dto.response.LoginResponse;
import com.BJJMarket.backend.modules.auth.repository.UserRepository;
import com.BJJMarket.backend.modules.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PersonRepository personRepository;
    private final UserStatusRepository userStatusRepository;
    private final RoleRepository roleRepository;


    @Override
    @Transactional
    //Transactional lo utilizamos ya que estamos manejando 3 entidades(Users, Person, UserStatus) y en el caso de que falle alguna insersion en una de estas 3 se deshace las inserciones anteriores
    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())){
            throw new UserAlreadyExistException(request.getUsername());
        }
        if (personRepository.existsByEmail(request.getEmail())){
            throw new UserAlreadyExistException(request.getEmail());
        }

        UserStatus status = userStatusRepository
                .findByName("ACTIVE")
                .orElseThrow(() -> new UserStatusNotFoundException("Active"));
        Role role = roleRepository
                .findByName("CUSTOMER")
                .orElseThrow(()-> new RoleNotFoundExcetion("CUSTOMER"));
        //Se crea la persona
        Person person = new Person();

        person.setName(request.getName());
        person.setLastName(request.getLastName());
        person.setBirthDate(request.getBirthDate());
        person.setPhone(request.getPhone());
        person.setEmail(request.getEmail());

        //Se guardan los datos en la entidad Person
        person = personRepository.save(person);


        //Se cre el usuario
        Users user = new Users();

        user.setPerson(person);
        user.setUserStatus(status);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        user = userRepository.save(user);

        //Ahora se crea la relacion del usuario con el rol
        UserRole userRole = new UserRole();

        userRole.setUser(user);
        userRole.setRole(role);

        return userMapper.toDTO(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public List<UserResponse> findALL(String filter) {
        List<Users> users = userRepository.findAll(filter);
        return  userMapper.toDTOList(users);
    }

    @Override
    public UserResponse findById(UUID userId) {
        Users user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundExecption(userId));
        return userMapper.toDTO(user);
    }
}