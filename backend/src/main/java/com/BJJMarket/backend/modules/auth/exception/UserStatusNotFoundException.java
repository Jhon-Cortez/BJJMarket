package com.BJJMarket.backend.modules.auth.exception;

public class UserStatusNotFoundException extends RuntimeException {
    public UserStatusNotFoundException(String name) {
        super("El estado " + name + " no fue encontrado");
    }
}
