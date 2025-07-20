package com.api.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.users.factory.ConnectionFactory;
import com.api.users.models.UsersModel;

@Service
public class UsersDAO {

    @Transactional(readOnly = true)
    public ArrayList<UsersModel> getUsers() throws SQLException {
        ArrayList<UsersModel> users = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection()) {
            final String QUERY = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(QUERY);
            try (statement) {
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet) {
                    while (resultSet.next()) {
                        UsersModel user = new UsersModel();

                        user.setId(resultSet.getLong("id"));
                        user.setFirst_name(resultSet.getString("first_name"));
                        user.setLast_name(resultSet.getString("last_name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setAddress(resultSet.getString("address"));
                        user.setCity(resultSet.getString("city"));
                        user.setPhone(resultSet.getLong("phone"));

                        users.add(user);
                    }
                }
            }
            return users;
        }
    }

    @Transactional(readOnly = true)
    public ArrayList<UsersModel> getUserById(long id) throws SQLException {
        ArrayList<UsersModel> users = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection()) {
            final String QUERY = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(QUERY);
            try (statement) {
                statement.setLong(1, id);
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet) {
                    while (resultSet.next()) {
                        UsersModel user = new UsersModel();

                        user.setId(resultSet.getLong("id"));
                        user.setFirst_name(resultSet.getString("first_name"));
                        user.setLast_name(resultSet.getString("last_name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setAddress(resultSet.getString("address"));
                        user.setCity(resultSet.getString("city"));
                        user.setPhone(resultSet.getLong("phone"));

                        users.add(user);
                    }
                }
            }
            return users;
        }
    }

    @Transactional
    public int saveUser(String first_name, String last_name, String gender, String address, String city, long phone) throws SQLException {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            final String QUERY = "INSERT INTO users (first_name, last_name, gender, address, city, phone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(QUERY);
            try (statement) {
                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setString(3, gender);
                statement.setString(4, address);
                statement.setString(5, city);
                statement.setLong(6, phone);
                int row = statement.executeUpdate();
                
                return row;
            }
        }
    }
}
