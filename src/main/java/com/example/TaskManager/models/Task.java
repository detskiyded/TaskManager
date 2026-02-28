package com.example.TaskManager.models;

import java.time.LocalDateTime;

public class Task {
    int id;
    String title;
    String description;
    Priority priority;
    Status status;
    LocalDateTime createdAt;

    public void getInfo(){
        System.out.println("Task ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
        System.out.println("Created at: " + createdAt);
    }

    public Task(int i, String t, String d, Priority p, Status s, LocalDateTime ldt){
        this.id = i;
        this.title = t;
        this.description = d;
        this.priority = p;
        this.status = s;
        this.createdAt = ldt;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
