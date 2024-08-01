package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TodoController {
    @Autowired
    private TodoJpaService todoJpaService;

    @GetMapping("/todos")
    public java.util.List<Todo> getTodos() {
        return todoJpaService.getTodos();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoJpaService.addTodo(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable int id) {
        return todoJpaService.getTodoById(id);
    }

    @PutMapping("todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        return todoJpaService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoJpaService.deleteTodo(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}