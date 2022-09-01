package com.example.backend.Service;

import com.example.backend.DTO.TaskDto;
import com.example.backend.Entities.Card;
import com.example.backend.Entities.Task;

import java.util.List;

public interface ITaskService {
    TaskDto findTaskById(String taskId);
    List<TaskDto> getAllTasks();
    boolean addTask(TaskDto taskDto);
    boolean deleteTask(String taskId);
    boolean updateTask(TaskDto taskDto);
    List<TaskDto> getAllTasksByCard(String cardId);
}
