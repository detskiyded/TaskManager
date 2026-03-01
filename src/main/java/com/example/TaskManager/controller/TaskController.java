package com.example.TaskManager.controller;

import com.example.TaskManager.models.Priority;
import com.example.TaskManager.models.Status;
import com.example.TaskManager.models.Task;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final List<Task> TaskList = new ArrayList<>();

    public TaskController(){
        TaskList.addAll(List.of(
                new Task("a", "b", Priority.LOW, Status.CREATED, LocalDateTime.now()),
                new Task("a", "b", Priority.HIGH, Status.CREATED, LocalDateTime.now()),
                new Task()
        ));
    }

    @GetMapping
    Iterable<Task> getTasks(){
        return TaskList;
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Long id){
        TaskList.removeIf(t -> Objects.equals(t.getId(), id));
    }

    @GetMapping("/{id}")
    Optional<Task> getTaskByID(@PathVariable Long id){
        for (Task t : TaskList){
            if (Objects.equals(t.getId(), id)){
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }
}
