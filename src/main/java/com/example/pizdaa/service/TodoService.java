package com.example.pizdaa.service;

import com.example.pizdaa.model.TodoModel;

import java.util.List;

public interface TodoService {
 List<TodoModel> getAllTodos();
 TodoModel getTodoById(Integer id);
 TodoModel saveTodo(TodoModel todoModel);
 void deleteTodo(Integer id);
 TodoModel updateTodo(Integer id, TodoModel todoModel);
}
