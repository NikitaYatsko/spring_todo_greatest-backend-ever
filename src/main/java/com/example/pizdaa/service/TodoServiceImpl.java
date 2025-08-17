package com.example.pizdaa.service;

import com.example.pizdaa.model.TodoModel;
import com.example.pizdaa.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }

    @Override
    public List<TodoModel> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public TodoModel getTodoById(Integer id) {
        return todoRepository.getReferenceById(id);
    }

    @Override
    public TodoModel saveTodo(TodoModel todoModel) {
        if (todoModel.getId() != null) {
            throw new IllegalArgumentException("Error while saving TodoModel");
        }
        return todoRepository.save(todoModel);
    }

    @Override
    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }

    @Override
    public TodoModel updateTodo(Integer id, TodoModel todoModel) {
        TodoModel existingTodoModel = getTodoById(id);

        existingTodoModel.setDescription(todoModel.getDescription());
        existingTodoModel.setDescription(todoModel.getDescription());
        existingTodoModel.setCompleted(todoModel.isCompleted());
        return todoRepository.save(existingTodoModel);
    }


}
