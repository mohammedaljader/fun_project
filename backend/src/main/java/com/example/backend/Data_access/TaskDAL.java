package com.example.backend.Data_access;

import com.example.backend.Entities.Card;
import com.example.backend.Entities.Task;
import com.example.backend.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAL implements ITaskDAL {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskDAL(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task findTaskById(String taskId) {
        return taskRepository.findByTaskId(taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasksByCard(Card card) {
        return taskRepository.findAllByCard(card);
    }
}
