package com.example.taskifyapi.service.event.model;

import com.example.taskifyapi.service.event.model.event_types.RegularEventModel;
import java.util.UUID;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class AnswerDeletedEvent extends RegularEventModel {
  private final UUID answerId;
}
