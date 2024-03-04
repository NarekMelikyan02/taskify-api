package com.example.taskifyapi.entity;

import com.example.taskifyapi.entity.enums.TaskPriority;
import com.example.taskifyapi.entity.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "task_priority")
  @Enumerated(EnumType.STRING)
  private TaskPriority priority;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  TaskStatus status;

  public TaskEntity() {
    this.status = TaskStatus.CREATED;
  }

  @ManyToOne
  @JoinColumn(name = "user_id")
  UserEntity asignedTo;
}
