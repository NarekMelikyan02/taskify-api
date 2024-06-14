package com.example.taskifyapi.controller;

import com.example.taskifyapi.dto.task.TaskAnswerDto;
import com.example.taskifyapi.service.answer.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Answers")
@RequiredArgsConstructor
public class TaskAnswerController {

    private final AnswerService answerService;

    @GetMapping("/getAll")
    ResponseEntity<List<TaskAnswerDto>> getAll(){
        return ResponseEntity.ok(answerService.getAll());
    }
}
