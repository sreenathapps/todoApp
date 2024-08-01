package com.example.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;

/**
 * TodoJpaService
 */
@Service
public class TodoJpaService implements TodoRepository {
    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = todoJpaRepository.findAll();
        return todos;
    }

    @Override
    public Todo addTodo(Todo todo) {
        todo.setId(0);
        todoJpaRepository.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        try {
            Todo newTodo = todoJpaRepository.findById(id).get();
            if (todo.getPriority() != null) {
                newTodo.setPriority(todo.getPriority());
            }
            if (todo.getStatus() != null) {
                newTodo.setStatus(todo.getStatus());
            }
            if (todo.getTodo() != null) {
                newTodo.setTodo(todo.getTodo());
            }
            todoJpaRepository.save(newTodo);
            return newTodo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            Todo todo = todoJpaRepository.findById(id).get();
            return todo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            todoJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}