package com.example.taskifyapi.service.answer;

import com.example.taskifyapi.dto.task.TaskAnswerDto;
import com.example.taskifyapi.entity.TaskAnswerEntity;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public TaskAnswerDto map(TaskAnswerEntity taskAnswer){
        return TaskAnswerDto.builder()
                .id(taskAnswer.getId())
                .answer(taskAnswer.getAnswer())
                .answerOf(taskAnswer.getTask())
                .build();
    }
}
