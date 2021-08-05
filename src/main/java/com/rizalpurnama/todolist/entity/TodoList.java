package com.rizalpurnama.todolist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class TodoList {
    private int id;
    private String activity;

    public TodoList() {
    }

    public TodoList(int id, String activity) {
        this.id = id;
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoList todoList = (TodoList) o;
        return Objects.equals(id, todoList.id) && Objects.equals(activity, todoList.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activity);
    }
}
