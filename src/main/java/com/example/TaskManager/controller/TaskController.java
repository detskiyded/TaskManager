package com.example.TaskManager.controller;

import com.example.TaskManager.models.Task;
import com.example.TaskManager.service.ITaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    void deleteTask(@Validated @PathVariable Long id){
        ITaskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    Optional<Task> getTaskByID(@PathVariable Long id){
        return ITaskService.getTaskByID(id);
    }

    @PostMapping
    Task postTask(@RequestBody Task task){
        return ITaskService.postTask(task);
    }

    @PutMapping("/{id}")
    ResponseEntity<Task> putTask(@PathVariable Long id,
                                 @RequestBody Task task){
        return ITaskService.putTask(id, task);
    }

}
