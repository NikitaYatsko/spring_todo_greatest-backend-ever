package com.example.pizdaa.controller;

import com.example.pizdaa.model.TodoModel;
import com.example.pizdaa.service.TodoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoModel> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("{id}")
    public TodoModel getTodoById(@PathVariable Integer id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public TodoModel saveTodo(@RequestBody TodoModel todoModel) {
        return todoService.saveTodo(todoModel);
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
    }

    @PutMapping("{id}")
    public TodoModel updateTodo(@PathVariable Integer id,@RequestBody TodoModel todoModel) {
        return todoService.updateTodo(id,todoModel);
    }
}
