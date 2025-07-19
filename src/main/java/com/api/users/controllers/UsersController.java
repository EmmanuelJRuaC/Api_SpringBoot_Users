package com.api.users.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    // Metodo para obtener toda la lista de usuarios
    @GetMapping("/getusers")
    public String getUsers() {
        return "COMENZAMOS CON EL PRIMER REDIRIGIMIENTO";
    }
    
}