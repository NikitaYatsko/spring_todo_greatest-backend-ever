package com.example.pizdaa.repository;

import com.example.pizdaa.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoModel, Integer> {
}
