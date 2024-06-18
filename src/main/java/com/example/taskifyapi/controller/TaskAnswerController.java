package com.example.taskifyapi.controller;

import com.example.taskifyapi.dto.task_answer.TaskAnswerDto;
import com.example.taskifyapi.dto.task_answer.TaskAnswerRequest;
import com.example.taskifyapi.service.answer.TaskAnswerService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Answers")
@RequiredArgsConstructor
public class TaskAnswerController {

  private final TaskAnswerService answerService;

  @GetMapping("/getAll")
  public ResponseEntity<List<TaskAnswerDto>> getAll() {
    return ResponseEntity.ok(answerService.getAll());
  }

  @PostMapping("/submit")
  public ResponseEntity<TaskAnswerDto> submitAnswer(@RequestBody TaskAnswerRequest request) {
    return ResponseEntity.ok(answerService.addAnswer(request));
  }

  @DeleteMapping("/deleteBy/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable(name = "id") UUID answerId) {
    answerService.deleteAnswerById(answerId);
  }
}
