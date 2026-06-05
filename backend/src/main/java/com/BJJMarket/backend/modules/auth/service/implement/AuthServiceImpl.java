package com.BJJMarket.backend.modules.auth.service.implement;

import com.BJJMarket.backend.modules.auth.dto.response.UserResponse;
import com.BJJMarket.backend.modules.auth.entity.Users;
import com.BJJMarket.backend.modules.auth.exception.UserNotFoundExecption;
import com.BJJMarket.backend.modules.auth.mapper.UserMapper;
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


    @Override
    public UserResponse register(RegisterRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public List<UserResponse> findALL(String filter) {
        return userMapper.toDTOList(userRepository.findAll(filter));
    }

    @Override
    public UserResponse findById(UUID userId) {
        Users user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundExecption(userId));
        return userMapper.toDTO(user);
    }
}