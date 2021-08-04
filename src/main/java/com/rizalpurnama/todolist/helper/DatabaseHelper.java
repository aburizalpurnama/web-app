package com.rizalpurnama.todolist.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    public static Connection connect(){
        String url = "jdbc:mysql://localhost/db_todolist";
        String username = "root";
        String password = "admin";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        return connection;
    }
}
