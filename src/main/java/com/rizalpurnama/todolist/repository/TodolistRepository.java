package com.rizalpurnama.todolist.repository;

import com.rizalpurnama.todolist.entity.TodoList;

import java.util.List;

public interface TodolistRepository {
    List<TodoList> getAll();

    void add(TodoList todoList);

    boolean remove(Integer number);

    Integer getKey();
}
