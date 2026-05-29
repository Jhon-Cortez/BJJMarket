package com.BJJMarket.backend.modules.auth.service;

import com.BJJMarket.backend.modules.auth.dto.request.LoginRequest;
import com.BJJMarket.backend.modules.auth.dto.request.RegisterRequest;
import com.BJJMarket.backend.modules.auth.dto.response.LoginResponse;

public interface AuthService {
    void register(RegisterRequest reques);
    LoginResponse login(LoginRequest request);
}
