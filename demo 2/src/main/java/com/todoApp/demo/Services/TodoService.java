package com.todoApp.demo.Services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import com.todoApp.demo.models.Todo;
import org.springframework.stereotype.Service;
import com.todoApp.demo.repository.TodoRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    // public TodoService(TodoRepository todoRepository){
    //     this.todoRepository=todoRepository;
    // }

    public Todo addTodo(Todo todo){
        if(todo!=null){
            todoRepository.save(todo);
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println(todo.toString());

            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
        }
        return todo;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo getTodoById(@NonNull String id){
        return todoRepository.findById(id).orElse(null);
    }
    
    public Todo udpdateTodoById(@NonNull String id,Todo newTodo){
        Todo curr = todoRepository.findById(id).orElse(null);
        if(curr!=null){
            curr.setDescription(newTodo.getDescription());
            curr.setTitle(newTodo.getTitle());
            todoRepository.save(curr);
        }
        return curr;
    }

    public boolean deleteTodo(@NonNull String id){
        if(todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
