package com.example.backend.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false,length = 36)
    private String taskId;
    private String taskTitle;
    private boolean taskStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    public Task(String taskTitle, boolean taskStatus) {
        this.taskTitle = taskTitle;
        this.taskStatus = taskStatus;
    }

    public Task(String taskId, String taskTitle, boolean taskStatus) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskStatus = taskStatus;
    }

    public Task(String taskTitle, boolean taskStatus, Card card) {
        this.taskTitle = taskTitle;
        this.taskStatus = taskStatus;
        this.card = card;
    }
}
