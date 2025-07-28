package com.api.users.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.api.users.dao.UsersDAO;
import com.api.users.models.UsersModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                    .badRequest()
                    .body(Map.of("Error", "Usuario no encontrado"));
        } else {
            return ResponseEntity.ok(user); // retorna los datos encontrados
        }
    }

    // Metodo para guardar nuevos usuarios (Formato JSON)
    @PostMapping("/saveuserjson")
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody UsersModel usersModel) throws SQLException {
        if (usersModel.getPhone() == null) {
            return ResponseEntity.
            badRequest().
            body(Map.of("Error:", "El campo phone es obligatorio"));    
        }
        
        int row = usersDAO.saveUser(
                usersModel.getFirst_name(),
                usersModel.getLast_name(),
                usersModel.getGender(),
                usersModel.getAddress(),
                usersModel.getCity(),
                usersModel.getPhone()
            );

        if (row > 0) {
            return ResponseEntity.
            ok().
            body(Map.of("Mensaje:", "¡Usuario creado con exito!"));
        }

        return null;
    }

    // Metodo para guardar nuevos usuarios (Formato URL)
    @PostMapping("/saveuserurl")
    public ResponseEntity<Map<String, String>> saveUser(
        @RequestParam String first_name,
        @RequestParam String last_name,
        @RequestParam String gender,
        @RequestParam String address,
        @RequestParam String city,
        @RequestParam(required = false) Long phone) throws SQLException {

        if (phone == null) {
            return ResponseEntity.
            badRequest().
            body(Map.of("Error:", "El campo phone es obligatorio"));    
        }

        int row = usersDAO.saveUser(first_name, last_name, gender, address, city, phone);

        if (row > 0) {
            return ResponseEntity.
            ok().
            body(Map.of("Mensaje:", "¡Usuario creado con exito!"));
        }
        return null;
    }

    // Metodo para actualizar nuevos usuarios (Formato JSON)
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<Map<String, String>> updateUser(
        @PathVariable Long id, @RequestBody UsersModel usersModel) throws SQLException {
        
        if (usersModel.getPhone() == null) {
            return ResponseEntity.
            badRequest().
            body(Map.of("Error:", "El campo phone es obligatorio"));    
        }
        
        int row = usersDAO.updateUser(
                id,
                usersModel.getFirst_name(),
                usersModel.getLast_name(),
                usersModel.getGender(),
                usersModel.getAddress(),
                usersModel.getCity(),
                usersModel.getPhone()
            );

        if (row > 0) {
            return ResponseEntity.
            ok().
            body(Map.of("Mensaje:", "¡Usuario actualizado con exito!"));
        }

        return null;
    }

    // Metodo para eliminar usuario
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) throws SQLException {
        int row = usersDAO.deleteUser(id);

        if (row > 0) {
            return ResponseEntity.
            ok().
            body(Map.of("Mensaje:", "¡Usuario eliminado con exito!"));
        }

        return ResponseEntity.
            status(HttpStatus.NOT_FOUND).
            body(Map.of("Error:", "¡Usuario no encontrado!"));
    }
}