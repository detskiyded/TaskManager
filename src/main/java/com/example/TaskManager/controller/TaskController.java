package com.example.TaskManager.controller;

import com.example.TaskManager.models.Priority;
import com.example.TaskManager.models.Status;
import com.example.TaskManager.models.Task;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class TaskController {

    private final List<Task> TaskList = new ArrayList<>();

    public TaskController(){
        TaskList.addAll(List.of(
                new Task(1, "a", "b", Priority.LOW, Status.CREATED, LocalDateTime.now()),
                new Task(2, "a", "b", Priority.HIGH, Status.CREATED, LocalDateTime.now())
        ));
    }

    @GetMapping("/tasks")
    Iterable<Task> getTasks(){
        return TaskList;
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable int id){
        TaskList.removeIf(t -> t.getId() == id);
    }

    @GetMapping("/tasks/{id}")
    Optional<Task> getTaskByID(@PathVariable int id){
        for (Task t : TaskList){
            if (t.getId() == id){
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }
}
