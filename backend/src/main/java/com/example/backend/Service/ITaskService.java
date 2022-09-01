package com.example.backend.Service;

import com.example.backend.Entities.Card;
import com.example.backend.Entities.Task;

import java.util.List;

public interface ITaskService {
    Task findTaskById(String taskId);
    List<Task> getAllTasks();
    boolean addTask(Task task);
    boolean deleteTask(String taskId);
    boolean updateTask(Task task);
    List<Task> getAllTasksByCard(String cardId);
}
