package com.todoApp.demo.models;

public class Todo {
    private String description;
    private boolean status;
    private int id;
    private String title;
    public Todo() {}

    public Todo(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.status = completed;
    }

    public String getDescription() {
        return this.description;
    }  
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isStatus() {
        return this.status; 
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

}
