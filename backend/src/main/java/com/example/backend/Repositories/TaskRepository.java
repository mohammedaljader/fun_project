package com.example.backend.Repositories;

import com.example.backend.Entities.Card;
import com.example.backend.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findAllByCard(Card card);
    Task findByTaskId(String taskId);
}
