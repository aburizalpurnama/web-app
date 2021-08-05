package com.rizalpurnama.todolist.helper;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
public class KoneksiDatabase {
    private String url;
    private String username ;
    private String password ;
    private Connection connection;

    @SneakyThrows
    public void connect(){
        Class driver_class = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) driver_class.getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(driver);
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
