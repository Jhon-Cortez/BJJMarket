package com.BJJMarket.backend.modules.auth.exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String username){
        super("El usuario '" + username + "'Ya existe");
    }
}
