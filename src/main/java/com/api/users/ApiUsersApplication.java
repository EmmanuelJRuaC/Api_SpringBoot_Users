package com.api.users;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class ApiUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsersApplication.class, args);
	}

	// Redireccionamiento al controlador "UsersControllers"
	@RequestMapping("/")
	public void redirigir(HttpServletResponse response) throws IOException {
		response.sendRedirect("/users/getusers");
	}

}