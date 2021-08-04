package com.rizalpurnama.todolist.repository;

import com.rizalpurnama.todolist.entity.TodoList;

import java.util.List;

public class TodolistRepositoryImpl implements TodolistRepository{
    @Override
    public List<TodoList> getAll() {
        return null;
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
