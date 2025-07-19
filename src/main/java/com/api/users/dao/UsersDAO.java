package com.api.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.api.users.factory.ConnectionFactory;
import com.api.users.models.UsersModel;

import jakarta.transaction.Transactional;

public class UsersDAO {

    @Transactional
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
}
