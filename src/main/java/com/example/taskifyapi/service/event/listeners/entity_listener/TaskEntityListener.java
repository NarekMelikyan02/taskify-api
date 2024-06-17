package com.example.taskifyapi.service.event.listeners.entity_listener;

import com.example.taskifyapi.entity.TaskEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TaskEntityListener {

    @PrePersist
    @PreUpdate
    public void setDeletedOnAnswerEntity(TaskEntity task){
        if(task.getAnswer()!=null && task.getDeleted() !=null){
            task.getAnswer().setDeleted(task.getDeleted());
        }
    }

}
