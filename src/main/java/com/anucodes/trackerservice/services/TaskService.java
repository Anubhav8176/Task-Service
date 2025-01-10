package com.anucodes.trackerservice.services;


import com.anucodes.trackerservice.entities.TaskEntity;
import com.anucodes.trackerservice.models.TaskDto;
import com.anucodes.trackerservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Boolean addNewTask(TaskDto taskDto){

        if (
                taskDto.getTitle().isEmpty() &&
                taskDto.getDescription().isEmpty()
        ){
            return false;
        }

        TaskEntity taskEntity = new TaskEntity(
                taskDto.getUserId(),
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.getStatus()
        );

        taskRepository.save(taskEntity);

        return true;

    }

    public boolean deleteTask(TaskDto taskDto){

        if (
                taskDto.getTitle().isEmpty() &&
                        taskDto.getDescription().isEmpty()
        ){
            return false;
        }

        TaskEntity taskEntity = new TaskEntity(
                taskDto.getUserId(),
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.getStatus()
        );

        taskRepository.delete(taskEntity);

        return true;

    }

    public List<TaskDto> getTaskByUserId(String userId){
        List<TaskEntity> tasks = taskRepository.findTaskEntitiesByUserId(userId);
        List<TaskDto> taskToReturn = new ArrayList<>();

        for (TaskEntity t : tasks){
            TaskDto tempTask = new TaskDto(
                    t.getUserId(),
                    t.getTitle(),
                    t.getDescription(),
                    t.getStatus()
            );

            taskToReturn.add(tempTask);
        }

        return taskToReturn;
    }

}
