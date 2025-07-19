package com.api.users.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        String url = "jdbc:mysql://mysql-emmanuelrua.alwaysdata.net:3306/emmanuelrua_proyectotweb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "379340";
        String password = "Ema20031011@";

        try {
            System.out.println("Conectado");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
