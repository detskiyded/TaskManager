package com.example.TaskManager.controller;

import com.example.TaskManager.models.Task;
import com.example.TaskManager.service.ITaskService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/{id}")
    Optional<Task> getTaskByID(@PathVariable Long id){
        return ITaskService.getTaskByID(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void deleteTask(@PathVariable Long id){
        ITaskService.deleteTask(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    Task postTask(@Valid @RequestBody Task task){
        return ITaskService.postTask(task);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Task> putTask(@Valid @PathVariable Long id,
                                 @Valid @RequestBody Task task){
        return ITaskService.putTask(id, task);
    }

}
