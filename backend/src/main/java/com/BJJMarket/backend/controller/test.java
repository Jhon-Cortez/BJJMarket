package com.BJJMarket.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/test")
public class test {
    
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola mundooo";
    }
}
