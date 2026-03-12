package com.example.TaskManager.service;

import com.example.TaskManager.models.Task;
import com.example.TaskManager.repo.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> getTask() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Optional<Task> getTaskByID(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task postTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public ResponseEntity<Task> putTask(Long id, Task task) {
        return (taskRepository.existsById(id))
                ? new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK)
                : new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
    }
}
