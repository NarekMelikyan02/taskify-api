package com.example.taskifyapi.service.event.model;

import com.example.taskifyapi.entity.TaskAnswerEntity;
import com.example.taskifyapi.service.event.model.event_types.RegularEventModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class AnswerPublishedEvent extends RegularEventModel {
  private String title;
  private String content;
  private TaskAnswerEntity answer;
}
