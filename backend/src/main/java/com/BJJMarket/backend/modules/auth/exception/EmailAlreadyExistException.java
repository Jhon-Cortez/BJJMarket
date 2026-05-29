package com.BJJMarket.backend.modules.auth.exception;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(String email){
        super("El email '"+ email + "' ya existe");
    }
}
