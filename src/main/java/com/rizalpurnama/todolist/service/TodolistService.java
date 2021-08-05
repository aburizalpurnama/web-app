package com.rizalpurnama.todolist.service;

public interface TodolistService {
    void showTodoList();

    void addTodoList(String todo);

    void removeTodoList(Integer number);
}
