package com.example.TaskManager.controller;

import com.example.TaskManager.models.Priority;
import com.example.TaskManager.models.Status;
import com.example.TaskManager.models.Task;
import com.example.TaskManager.repo.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepo;

    public TaskController(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
        taskRepo.saveAll(List.of(
                new Task(),
                new Task(),
                new Task()
        ));
    }

    @GetMapping
    Iterable<Task> getTasks(){
        return taskRepo.findAll();
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Long id){
        taskRepo.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<Task> getTaskByID(@PathVariable Long id){
        return taskRepo.findById(id);
    }

    @PostMapping
    Task postTask(@RequestBody Task task){
        return taskRepo.save(task);
    }

    @PutMapping("/{id}")
    ResponseEntity<Task> putTask(@PathVariable Long id,
                                 @RequestBody Task task){
        return (!taskRepo.existsById(id))
                ? new ResponseEntity<>(taskRepo.save(task), HttpStatus.CREATED)
                : new ResponseEntity<>(taskRepo.save(task), HttpStatus.OK);
    }

}
