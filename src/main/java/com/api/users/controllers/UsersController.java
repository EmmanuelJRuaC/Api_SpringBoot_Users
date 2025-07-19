package com.api.users.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.api.users.dao.UsersDAO;
import com.api.users.models.UsersModel;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    private UsersDAO usersDAO;

    // Metodo para obtener toda la lista de usuarios
    @GetMapping("/getusers")
    public ArrayList<UsersModel> getUsers() throws SQLException {
        return usersDAO.getUsers();
    }
    
}