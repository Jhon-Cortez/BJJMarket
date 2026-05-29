package com.BJJMarket.backend.modules.auth.mapper;

import org.springframework.stereotype.Component;

import com.BJJMarket.backend.modules.auth.dto.response.UserResponse;
import com.BJJMarket.backend.modules.auth.entity.Users;

@Component
public class UserMapper {
    public UserResponse toResponse(Users user){
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getPerson().getEmail())
                .status(user.getUserStatus().getName())
                .build();
    }
}
