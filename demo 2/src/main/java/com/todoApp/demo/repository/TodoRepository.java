package com.todoApp.demo.repository;

import com.todoApp.demo.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo,String> {

    
}
