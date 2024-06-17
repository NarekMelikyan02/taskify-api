package com.example.taskifyapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "answers")
public class TaskAnswerEntity extends BaseEntity {

  @Column(name = "answer", nullable = false)
  private String answer;
}
