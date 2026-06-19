package com.BJJMarket.backend.modules.auth.dto.request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "DTO para el registro de un nuevo usuario")
public class RegisterRequest {
    
    @NotBlank(message = "El nombre es requerido")
    @Schema(description = "Nombre del usuario", example = "Juan")
    private String name;
    
    @NotBlank(message = "El apellido es requerido")
    @Schema(description = "Apellido del usuario", example = "Pérez")
    private String lastName;
    
    @NotNull(message = "La fecha de nacimiento es requerida")
    @Schema(description = "Fecha de nacimiento del usuario", example = "1990-05-15")
    private LocalDate birthDate;
    
    @NotBlank(message = "El teléfono es requerido")
    @Schema(description = "Número de teléfono", example = "+57 300 1234567")
    private String phone;
    
    @NotBlank(message = "El email es requerido")
    @Email(message = "El email debe ser válido")
    @Schema(description = "Correo electrónico del usuario", example = "juan@example.com")
    private String email;
    
    @NotBlank(message = "El usuario es requerido")
    @Schema(description = "Nombre de usuario (username)", example = "juan_perez")
    private String username;
    
    @NotBlank(message = "La contraseña es requerida")
    @Schema(description = "Contraseña del usuario (mínimo 8 caracteres)", example = "MiPassword123")
    private String password;
}
