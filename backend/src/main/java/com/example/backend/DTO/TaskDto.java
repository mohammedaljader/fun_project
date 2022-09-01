package com.example.backend.DTO;

public class TaskDto {
    private String taskId;
    private String taskTitle;
    private boolean taskStatus;
    private String cardId;

    public TaskDto(String taskId, String taskTitle, boolean taskStatus, String cardId) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskStatus = taskStatus;
        this.cardId = cardId;
    }

    public TaskDto(String taskTitle, String cardId) {
        this.taskTitle = taskTitle;
        this.cardId = cardId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
