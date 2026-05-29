package com.BJJMarket.backend.modules.auth.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String username;
    private String password;
}
