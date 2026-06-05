package com.BJJMarket.backend.modules.auth.dto.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    private UUID userId;
    private String username;
    private String email;
    private String status;
}
