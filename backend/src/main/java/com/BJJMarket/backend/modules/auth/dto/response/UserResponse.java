package com.BJJMarket.backend.modules.auth.dto.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private UUID userId;
    private String username;
    private String email;
    private String status;
}
