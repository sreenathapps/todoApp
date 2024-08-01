package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.model.Todo;

/**
 * TodoJpaRepository
 */
public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {
}