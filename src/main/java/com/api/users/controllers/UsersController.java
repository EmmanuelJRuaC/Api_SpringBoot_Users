package com.api.users.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.api.users.dao.UsersDAO;
import com.api.users.models.UsersModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Metodo busqueda de usuario por ID
    @GetMapping("/getuser/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) throws SQLException {
        ArrayList<UsersModel> user = new ArrayList<>();
        user.addAll(usersDAO.getUserById(id));

        if (user.isEmpty()) {
            // Retornar un JSON con un mensaje personalizado
            return ResponseEntity
                    .status(404)
                    .body(Map.of("error", "Usuario no encontrado"));
        } else {
            return ResponseEntity.ok(user); // retorna los datos encontrados
        }
    }


}