package com.rizalpurnama.todolist.service;

import com.rizalpurnama.todolist.repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService{
    TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodoList() {
        todolistRepository.getAll();

    }

    @Override
    public void addTodoList(String todo) {

    }

    @Override
    public void removeTodoList(Integer number) {

    }
}
