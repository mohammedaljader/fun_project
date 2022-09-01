package com.example.backend.Service;

import com.example.backend.DTO.TaskDto;
import com.example.backend.Data_access.ICardDAL;
import com.example.backend.Data_access.ITaskDAL;
import com.example.backend.Entities.Card;
import com.example.backend.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public TaskDto findTaskById(String taskId) {
        Task task =  taskDAL.findTaskById(taskId);
        return new TaskDto(task.getTaskId(), task.getTaskTitle(), task.isTaskStatus(), task.getCard().getCardId());
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<TaskDto> taskDtos = new ArrayList<>();
        List<Task> tasks= taskDAL.getAllTasks();
        for (Task task: tasks) {
            TaskDto taskDto = new TaskDto(task.getTaskId(), task.getTaskTitle(), task.isTaskStatus(), task.getCard().getCardId());
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }

    @Override
    public boolean addTask(TaskDto taskDto) {
        Card card = cardDAL.findCardById(taskDto.getCardId());
        Task task = new Task(taskDto.getTaskTitle(), false, card);
        return taskDAL.addTask(task) != null;
    }

    @Override
    public boolean deleteTask(String taskId) {
        Task task = taskDAL.findTaskById(taskId);
        taskDAL.deleteTask(task);
        return taskDAL.findTaskById(task.getTaskId()) == null;
    }

    @Override
    public boolean updateTask(TaskDto taskDto) {
        Task oldTask = taskDAL.findTaskById(taskDto.getTaskId());
        oldTask.setTaskId(taskDto.getTaskId());
        oldTask.setTaskStatus(taskDto.isTaskStatus());
        return taskDAL.updateTask(oldTask) != null;
    }

    @Override
    public List<TaskDto> getAllTasksByCard(String cardId) {
        List<TaskDto> taskDtos = new ArrayList<>();
        Card card = cardDAL.findCardById(cardId);
        List<Task> tasks =  taskDAL.getAllTasksByCard(card);
        for (Task task: tasks) {
            TaskDto taskDto = new TaskDto(task.getTaskId(), task.getTaskTitle(), task.isTaskStatus(), task.getCard().getCardId());
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }
}
