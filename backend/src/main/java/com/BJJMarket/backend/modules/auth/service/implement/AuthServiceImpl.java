package com.BJJMarket.backend.modules.auth.service.implement;

import com.BJJMarket.backend.modules.auth.dto.response.UserResponse;
import com.BJJMarket.backend.modules.auth.entity.*;
import com.BJJMarket.backend.modules.auth.exception.EmailAlreadyExistException;
import com.BJJMarket.backend.modules.auth.exception.RoleNotFoundExcetion;
import com.BJJMarket.backend.modules.auth.exception.UserAlreadyExistException;
import com.BJJMarket.backend.modules.auth.exception.UserNotFoundExecption;
import com.BJJMarket.backend.modules.auth.exception.UserStatusNotFoundException;
import com.BJJMarket.backend.modules.auth.mapper.UserMapper;
import com.BJJMarket.backend.modules.auth.repository.PersonRepository;
import com.BJJMarket.backend.modules.auth.repository.RoleRepository;
import com.BJJMarket.backend.modules.auth.repository.UserRoleRepository;
import com.BJJMarket.backend.modules.auth.repository.UserStatusRepository;
import com.BJJMarket.backend.modules.auth.security.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private static final String DEFAULT_STATUS = "ACTIVO";
    private static final String DEFAULT_ROLE = "BUYER";

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PersonRepository personRepository;
    private final UserStatusRepository userStatusRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Override
    @Transactional
    //Transactional lo utilizamos ya que estamos manejando 3 entidades(Users, Person, UserStatus) y en el caso de que falle alguna insersion en una de estas 3 se deshace las inserciones anteriores
    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())){
            throw new UserAlreadyExistException(request.getUsername());
        }
        if (personRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistException(request.getEmail());
        }

        UserStatus status = userStatusRepository
                .findByName(DEFAULT_STATUS)
                .orElseThrow(() -> new UserStatusNotFoundException(DEFAULT_STATUS));
        Role role = roleRepository
                .findByName(DEFAULT_ROLE)
                .orElseThrow(()-> new RoleNotFoundExcetion(DEFAULT_ROLE));
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
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user = userRepository.save(user);

        //Ahora se crea la relacion del usuario con el rol
        UserRole userRole = new UserRole();

        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);

        return userMapper.toDTO(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Users user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadCredentialsException("Usuario o contraseña incorrectos"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Usuario o contraseña incorrectos");
        }

        List<String> roles = userRoleRepository.findByUser_UserId(user.getUserId()).stream()
                .map(userRole -> userRole.getRole().getName())
                .toList();

        String token = jwtService.generateToken(user.getUsername(), roles);

        return LoginResponse.builder()
                .token(token)
                .username(user.getUsername())
                .roles(roles)
                .build();
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