// Write your code here
package com.example.todo.model;

/**
 * Todo
 */
public class Todo {

    private int id;
    private String todo;
    private String status;
    private String priority;

    public Todo(int id, String todo,String priority,  String status) {
        this.id = id;
        this.todo = todo;
        this.status = status;
        this.priority = priority;
    }
    public Todo() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }

    
}
