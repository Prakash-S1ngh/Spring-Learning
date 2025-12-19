package com.todoApp.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.demo.Services.TodoService;
import com.todoApp.demo.models.Todo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todos;
    public TodoController(TodoService services){
        this.todos = services;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todos.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable int id) {
        return todos.getTodoById(id);
    }
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todos.addTodo(todo);
    }
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo entity) {
        return todos.udpdateTodoById(id, entity);
    }
    
    @DeleteMapping
    public void deleteTodo(@RequestParam int id) {
        todos.deleteTodo(id);
    }
    
    

}
