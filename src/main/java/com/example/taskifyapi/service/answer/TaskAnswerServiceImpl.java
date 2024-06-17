package com.example.taskifyapi.service.answer;

import com.example.taskifyapi.dto.task_answer.TaskAnswerDto;
import com.example.taskifyapi.dto.task_answer.TaskAnswerRequest;
import com.example.taskifyapi.entity.TaskAnswerEntity;
import com.example.taskifyapi.enumeration.ListenersEventType;
import com.example.taskifyapi.repository.TaskAnswerEntityRepository;
import com.example.taskifyapi.service.event.model.AnswerPublishedEvent;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TaskAnswerServiceImpl implements TaskAnswerService {
  private final TaskAnswerEntityRepository answerRepository;
  private final ApplicationEventPublisher eventPublisher;
  private final TaskAnswerMapper answerMapper;

  @Override
  public List<TaskAnswerDto> getAll() {
    List<TaskAnswerEntity> allAnswers = answerRepository.findAll();
    return allAnswers.stream().map(answerMapper::map).toList();
  }

  @Override
  public TaskAnswerDto addAnswer(TaskAnswerRequest request) {
    TaskAnswerEntity taskAnswer = new TaskAnswerEntity();
    taskAnswer.setAnswer(request.answer());
    answerRepository.save(taskAnswer);
    log.info("Preparing to send an event");

    eventPublisher.publishEvent(
        AnswerPublishedEvent.builder()
            .title(request.title())
            .content(request.content())
            .answer(taskAnswer)
            .eventType(ListenersEventType.ANSWER_PUBLISHED)
            .build());
    return answerMapper.map(taskAnswer);
  }
}
