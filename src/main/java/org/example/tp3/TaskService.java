package org.example.tp3;



import org.example.tp3.Task; // Assure-toi d'importer ta classe Task correctement

import java.util.Optional;


import org.example.tp3.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void saveTask(Task task) {
        repository.save(task);
    }

    public Optional<Task> findTaskById(Long id) {
        return repository.findById(id);
    }

    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }
}

