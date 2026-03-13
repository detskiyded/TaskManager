package com.example.TaskManager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @NotBlank (message = "Title can't be blank!")
    @Size(min = 5, max = 50)
    @Getter @Setter
    private String title;

    @Size(min = 0, max = 150)
    @Getter @Setter
    private String description;

    @NotNull
    @Getter @Setter
    private Priority priority;

    @NotNull
    @Getter @Setter
    private Status status;

    @NotNull
    @Getter @Setter
    private LocalDateTime createdAt;

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
    public Task(String t, String d, Priority p, Status s){
        this.title = t;
        this.description = d;
        this.priority = p;
        this.status = s;
        this.createdAt = LocalDateTime.now();
    }

}
