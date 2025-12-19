package com.todoApp.demo.Services;

import com.todoApp.demo.models.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;


@Service
public class TodoService {
    private List<Todo>TodoList = new ArrayList<>();
    private int count=1;

    public Todo addTodo(Todo todo){
        todo.setId(count++);
        TodoList.add(todo);
        return todo;
    }

    public List<Todo> getAllTodos(){
        return TodoList;
    }

    public Todo getTodoById(int id){
        for(int i=0;i<TodoList.size();i++){
            Todo td = TodoList.get(i);
            if(td.getId() == id){
                return td;
            }
        }
        return null;
    }
    
    public Todo udpdateTodoById(int id,Todo newTodo){
        Todo curr = getTodoById(id);
        if(newTodo!=null && curr!=null){
            curr.setDescription(newTodo.getDescription());
            curr.setTitle(newTodo.getTitle());
        }

        return null;
    }

    public boolean deleteTodo(int id){

        for(int i=0;i<TodoList.size();i++){
            Todo td = TodoList.get(i);
            if(td.getId() == id){
                TodoList.remove(i);
                return true;
            }
        }
        return false;
    }


}
