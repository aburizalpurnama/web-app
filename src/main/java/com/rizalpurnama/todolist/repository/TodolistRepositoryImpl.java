package com.rizalpurnama.todolist.repository;

import com.rizalpurnama.todolist.entity.TodoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodolistRepositoryImpl implements TodolistRepository{

    Connection connection;

    public TodolistRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TodoList> getAll() {

        List<TodoList> listResult = new ArrayList<>();

        final String SQL_SELECT_ALL = "SELECT * FROM todo";
        try(PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                TodoList todoList = new TodoList();
                todoList.setId(resultSet.getInt("id"));
                todoList.setActivity(resultSet.getString("activity"));
                listResult.add(todoList);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return listResult;
    }

    @Override
    public void add(TodoList todoList) {

    }

    @Override
    public boolean remove(Integer number) {
        return false;
    }

    @Override
    public Integer getKey() {
        return null;
    }
}
