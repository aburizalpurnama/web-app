package com.rizalpurnama.todolist.repository;

import com.rizalpurnama.todolist.entity.TodoList;
import com.rizalpurnama.todolist.helper.KoneksiDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodolistDao {
    private KoneksiDatabase koneksiDatabase;

    public TodolistDao(KoneksiDatabase koneksiDatabase) {
        this.koneksiDatabase = koneksiDatabase;
    }

    public List<TodoList> getAll(){
        koneksiDatabase.connect();
        List<TodoList> listResult = new ArrayList<>();

        final String SQL_SELECT_ALL = "SELECT * FROM todo";
        try(PreparedStatement ps = koneksiDatabase.getConnection().prepareStatement(SQL_SELECT_ALL)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                TodoList todoList = new TodoList();
                todoList.setId(resultSet.getInt("id"));
                todoList.setActivity(resultSet.getString("activity"));
                listResult.add(todoList);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        koneksiDatabase.disconnect();
        return listResult;
    }
}
