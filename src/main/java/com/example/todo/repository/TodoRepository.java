// Write your code here
package com.example.todo.repository;
import com.example.todo.model.*;
import java.util.ArrayList;

/**
 * TodoRepository
 */
public interface TodoRepository {

    ArrayList<Todo> getTodos();
    Todo addTodo(Todo todo);
    Todo updateTodo(int id,Todo todo);
    void deleteTodo(int id);
    Todo getTodoById(int id);
}