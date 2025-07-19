package com.api.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.api.users.factory.ConnectionFactory;
import com.api.users.models.UsersModel;

@Service
public class UsersDAO {

    //@Transactional(readOnly = true)
    public ArrayList<UsersModel> getUsers() throws SQLException {
        ArrayList<UsersModel> users = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().getConnection()) {
            final String QUERY = "SELECT * FROM USERS";
            PreparedStatement statement = connection.prepareStatement(QUERY);
            try (statement) {          
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet) {
                    while (resultSet.next()) {
                        UsersModel user = new UsersModel();
                }
            }
        }
        return users;
        }
    }
}
