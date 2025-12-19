package com.todoApp.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/greet")
public class Greet {

    @GetMapping("/hello")
    public String greetingsString() {
        return "Hello  Prakash Kya kr rahe ho ";
    }
    
}
