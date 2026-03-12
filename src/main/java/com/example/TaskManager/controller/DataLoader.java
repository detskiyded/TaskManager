package com.example.TaskManager.controller;

import com.example.TaskManager.models.Task;
import com.example.TaskManager.repo.TaskRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final TaskRepository taskRepo;

    public DataLoader(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    @PostConstruct
    private void loadData(){
        taskRepo.saveAll(List.of(
                new Task(),
                new Task(),
                new Task()
        ));
    }
}
