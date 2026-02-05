package com.anucodes.trackerservice.controllers;


import com.anucodes.trackerservice.models.FetchTaskDto;
import com.anucodes.trackerservice.models.TaskDto;
import com.anucodes.trackerservice.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("add/")
    public ResponseEntity addNewTask(@RequestBody TaskDto taskDto){
        if (taskService.addNewTask(taskDto)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("delete/")
    public ResponseEntity deleteTask(@RequestBody TaskDto taskDto){

        if (taskService.deleteTask(taskDto)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("allTask/")
    public ResponseEntity getTasksByUserId(@RequestBody FetchTaskDto fetchTaskDto) {
        List<TaskDto> tasks = taskService.getTaskByUserId(fetchTaskDto.getUserId());
        return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
    }

}
