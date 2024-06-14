package com.example.taskifyapi.entity;

import com.example.taskifyapi.enumeration.AssignStatus;
import com.example.taskifyapi.enumeration.task.TaskPriority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tasks",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title","content"})
})
public class TaskEntity extends BaseEntity {
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "task_priority")
  @Enumerated(EnumType.ORDINAL)
  private TaskPriority priority;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private AssignStatus status;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity assignedTo;

  @OneToOne
  @JoinColumn(name = "answer_id")
  private TaskAnswerEntity answer;
}
