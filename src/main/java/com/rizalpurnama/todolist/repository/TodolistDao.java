package com.rizalpurnama.todolist.repository;

import com.rizalpurnama.todolist.entity.TodoList;
import com.rizalpurnama.todolist.helper.KoneksiDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TodolistDao {

    @Autowired
    private KoneksiDatabase koneksiDatabase;

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
