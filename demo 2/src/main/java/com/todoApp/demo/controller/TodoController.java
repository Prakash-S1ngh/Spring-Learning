package com.todoApp.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.demo.Services.TodoService;
import com.todoApp.demo.models.Todo;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getTodos() {
        List<Todo>res = todos.getAllTodos();
        if(res==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodo(@PathVariable String id) {
        Todo res = todos.getTodoById(id);
        if(res==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<?> addTodo(@RequestBody Todo todo) {
        Todo res = todos.addTodo(todo);
        if(res==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(res);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable String id, @RequestBody Todo entity) {
        Todo res = todos.udpdateTodoById(id, entity);
        if(res==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(res);
    }
    
    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@RequestParam String id) {
        boolean val = todos.deleteTodo(id);
        if(!val){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).build();
    }
    
    

}
