/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.model.Todo;
import com.example.todo.model.TodoRowMapper;
import com.example.todo.repository.TodoRepository;

import java.util.*;

/**
 * TodoH2Service
 */
@Service
public class TodoH2Service implements TodoRepository{

    @Autowired
    JdbcTemplate db;

    @Override
    public ArrayList<Todo> getTodos() {
        List<Todo> todoList = db.query("SELECT * FROM todolist", new TodoRowMapper());
        return new ArrayList<>(todoList);
    }
    @Override
    public void deleteTodo(int id) {
        db.update("DELETE FROM todolist WHERE id = ?", id);
        throw new ResponseStatusException(HttpStatus.OK);
    } 
    @Override
    public Todo getTodoById(int id) {
        try {
            Todo todo = db.queryForObject("SELECT * FROM todolist where id = ? ",new TodoRowMapper(), id);
            return todo;
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public Todo addTodo(Todo todo) {
        db.update("INSERT INTO TODOLIST(todo,status,priority)", todo.getTodo(),todo.getStatus(),todo.getPriority());
        Todo savedTodo = db.queryForObject("SELECT * from todolist where todo = ? and status = ? and priority = ? ", new TodoRowMapper(), todo.getTodo(), todo.getStatus(), todo.getPriority());
        return savedTodo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        if (todo.getTodo() != null) {
            db.update("UPDATE todolist set todo = ? where id = ? ", todo.getTodo(),id);
        }
        if (todo.getStatus() != null) {
            db.update("UPDATE todolist set status = ? where id = ? ", todo.getStatus(), id);
        }
        if (todo.getPriority() != null) {
            db.update("UPDATE todolist set priority = ? where id = ? ", todo.getPriority(), id);
        }

        return getTodoById(id);
    }
}