package com.example.TaskManager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime createdAt;

    public void getInfo(){
        System.out.println("Task ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
        System.out.println("Created at: " + createdAt);
    }

    public Task(){
        this.title = "Some task";
        this.description = "Some description";
        this.priority = Priority.LOW;
        this.status = Status.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public Task(String t, String d, Priority p, Status s, LocalDateTime ldt){
        this.title = t;
        this.description = d;
        this.priority = p;
        this.status = s;
        this.createdAt = ldt;
    }

    public Long getId() {
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
