package com.tms.backend.services;

import com.tms.backend.models.Task;
import com.tms.backend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(String title, String description, String status) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    // TODO : make this take an undetermined number of arguments
    public Task updateTask(Long id, String title, String description, String status) {
        Task task = taskRepository.findById(id).isPresent() ? taskRepository.findById(id).get() : new Task(); // TODO : this should actually throw an exception
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }





}

