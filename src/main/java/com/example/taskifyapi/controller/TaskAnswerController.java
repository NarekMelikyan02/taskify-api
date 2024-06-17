package com.example.taskifyapi.controller;

import com.example.taskifyapi.dto.task_answer.TaskAnswerDto;
import com.example.taskifyapi.dto.task_answer.TaskAnswerRequest;
import com.example.taskifyapi.service.task.answer.TaskAnswerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Answers")
@RequiredArgsConstructor
public class TaskAnswerController {

  private final TaskAnswerService answerService;

  @GetMapping("/getAll")
  ResponseEntity<List<TaskAnswerDto>> getAll() {
    return ResponseEntity.ok(answerService.getAll());
  }

  @PostMapping("/submit")
  ResponseEntity<TaskAnswerDto> submitAnswer(@RequestBody TaskAnswerRequest request){
      return ResponseEntity.ok(answerService.addAnswer(request));
  }

}
