package com.example.backend.Data_access;

import com.example.backend.Entities.Card;
import com.example.backend.Entities.Task;

import java.util.List;

public interface ITaskDAL {
    Task findTaskById(String taskId);
    List<Task> getAllTasks();
    Task addTask(Task task);
    void deleteTask(Task task);
    Task updateTask(Task task);

    List<Task> getAllTasksByCard(Card card);
}
