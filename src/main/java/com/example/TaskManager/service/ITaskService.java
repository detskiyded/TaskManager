package com.example.TaskManager.service;

import com.example.TaskManager.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface ITaskService {
    Iterable<Task> getTask();
    void deleteTask(@PathVariable Long id);
    Optional<Task> getTaskByID(@PathVariable Long id);
    Task postTask(@RequestBody Task task);
    ResponseEntity<Task> putTask(@PathVariable Long id,
                                 @RequestBody Task task);
}
