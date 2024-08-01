package com.example.todo.repository;

import java.util.List;

import com.example.todo.model.Todo;

/**
 * TodoRepository
 */
public interface TodoRepository {
    List<Todo> getTodos();
    Todo addTodo(Todo todo);
    Todo updateTodo(int id, Todo todo);
    Todo getTodoById(int id);
    void deleteTodo(int id);
}