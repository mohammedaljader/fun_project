package com.example.backend.Controllers;

import com.example.backend.DTO.MessageResponse;
import com.example.backend.DTO.TaskDto;
import com.example.backend.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class TaskController {
    private final ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService){
        this.taskService = taskService;
    }


    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> taskDtos = taskService.getAllTasks();
        if(taskDtos != null){
            return ResponseEntity.ok().body(taskDtos);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<List<TaskDto>> getAllTasksByCardId(@PathVariable String id){
        List<TaskDto> taskDtos = taskService.getAllTasksByCard(id);
        if(taskDtos != null){
            return ResponseEntity.ok().body(taskDtos);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable String id){
        TaskDto task = taskService.findTaskById(id);
        if(task != null){
            return ResponseEntity.ok().body(task);
        }else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping("/task")
    public ResponseEntity<MessageResponse> addTask(@RequestBody TaskDto taskDto){
        boolean result = taskService.addTask(taskDto);
        if(result){
            return ResponseEntity.ok().body(new MessageResponse("Task added successfully!!"));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<MessageResponse> deleteTask(@PathVariable String id){
        boolean result = taskService.deleteTask(id);
        if(result){
            return ResponseEntity.ok().body(new MessageResponse("Task deleted successfully!!"));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/task")
    public ResponseEntity<MessageResponse> updateTask(@RequestBody TaskDto taskDto){
        boolean result = taskService.updateTask(taskDto);
        if(result){
            return ResponseEntity.ok().body(new MessageResponse("Task updated successfully!!"));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
