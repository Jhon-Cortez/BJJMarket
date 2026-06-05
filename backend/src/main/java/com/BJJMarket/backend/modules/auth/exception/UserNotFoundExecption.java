package com.BJJMarket.backend.modules.auth.exception;

import java.util.UUID;

public class UserNotFoundExecption extends RuntimeException{
    public UserNotFoundExecption(UUID usuarioId){
        super("El usuario con la id:" + usuarioId + "No fue encontrado");
    }
}
