package com.example.backend.Service;

import com.example.backend.Data_access.ICardDAL;
import com.example.backend.Data_access.ITaskDAL;
import com.example.backend.Entities.Card;
import com.example.backend.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    private final ITaskDAL taskDAL;
    private final ICardDAL cardDAL;

    @Autowired
    public TaskService(ITaskDAL taskDAL,ICardDAL cardDAL){
        this.taskDAL = taskDAL;
        this.cardDAL = cardDAL;
    }

    @Override
    public Task findTaskById(String taskId) {
        return taskDAL.findTaskById(taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDAL.getAllTasks();
    }

    @Override
    public boolean addTask(Task task) {
        return taskDAL.addTask(task) != null;
    }

    @Override
    public boolean deleteTask(String taskId) {
        Task task = taskDAL.findTaskById(taskId);
        taskDAL.deleteTask(task);
        return taskDAL.findTaskById(task.getTaskId()) == null;
    }

    @Override
    public boolean updateTask(Task task) {
        Task oldTask = taskDAL.findTaskById(task.getTaskId());
        oldTask.setTaskId(task.getTaskId());
        oldTask.setTaskStatus(task.isTaskStatus());
        return taskDAL.updateTask(oldTask) != null;
    }

    @Override
    public List<Task> getAllTasksByCard(String cardId) {
        Card card = cardDAL.findCardById(cardId);
        return taskDAL.getAllTasksByCard(card);
    }
}
