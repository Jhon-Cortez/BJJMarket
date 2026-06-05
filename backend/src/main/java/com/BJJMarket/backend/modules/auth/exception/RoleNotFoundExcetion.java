package com.BJJMarket.backend.modules.auth.exception;

public class RoleNotFoundExcetion extends RuntimeException {
    public RoleNotFoundExcetion(String name) {
        super("El rol" + name + " no fue encontrado");
    }
}
