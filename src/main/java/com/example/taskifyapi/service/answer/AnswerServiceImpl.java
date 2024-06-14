package com.example.taskifyapi.service.answer;

import com.example.taskifyapi.dto.task.TaskAnswerDto;
import com.example.taskifyapi.entity.TaskAnswerEntity;
import com.example.taskifyapi.repository.TaskAnswerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{

    private final TaskAnswerEntityRepository repository;
    private final AnswerMapper mapper;

    @Override
    public List<TaskAnswerDto> getAll() {
        List<TaskAnswerEntity> allAnswers = repository.findAll();
        return allAnswers.stream().map(mapper::map).toList();
    }
}
