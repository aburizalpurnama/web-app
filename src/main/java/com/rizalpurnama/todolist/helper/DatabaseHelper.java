package com.rizalpurnama.todolist.helper;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    @SneakyThrows
    public static Connection connect(){
        String url = "jdbc:mysql://localhost/db_todolist";
        String username = "root";
        String password = "admin";

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

        return connection;
    }
}
