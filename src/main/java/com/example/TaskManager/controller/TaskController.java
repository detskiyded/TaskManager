package com.example.TaskManager.controller;

import com.example.TaskManager.models.Task;
import com.example.TaskManager.service.ITaskService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final ITaskService ITaskService;

    public TaskController(ITaskService ITaskService){
        this.ITaskService = ITaskService;
    }

    @GetMapping
    Iterable<Task> getTasks(){
        return ITaskService.getTask();
    }

    @DeleteMapping("/{id}")
    void deleteTask(@Valid @PathVariable Long id){
        ITaskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    Optional<Task> getTaskByID(@Valid @PathVariable Long id){
        return ITaskService.getTaskByID(id);
    }

    @PostMapping
    Task postTask(@Valid @RequestBody Task task){
        return ITaskService.postTask(task);
    }

    @PutMapping("/{id}")
    ResponseEntity<Task> putTask(@Valid @PathVariable Long id,
                                 @Valid @RequestBody Task task){
        return ITaskService.putTask(id, task);
    }

}
