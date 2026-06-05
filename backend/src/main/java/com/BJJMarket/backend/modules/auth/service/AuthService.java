package com.BJJMarket.backend.modules.auth.service;

import com.BJJMarket.backend.modules.auth.dto.request.LoginRequest;
import com.BJJMarket.backend.modules.auth.dto.request.RegisterRequest;
import com.BJJMarket.backend.modules.auth.dto.response.LoginResponse;
import com.BJJMarket.backend.modules.auth.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface AuthService {
    UserResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);

    List<UserResponse> findALL(String filter);
    UserResponse findById(UUID userId);



}
