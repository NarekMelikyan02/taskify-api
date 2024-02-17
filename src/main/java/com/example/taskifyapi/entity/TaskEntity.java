package com.example.taskifyapi.entity;

import com.example.taskifyapi.entity.enums.TaskPriority;
import com.example.taskifyapi.entity.enums.UserRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "task_priority")
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity asignedTo;
}
