package com.example.taskifyapi;

import com.example.taskifyapi.entity.TaskAnswerEntity;
import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.repository.TaskAnswerEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class TaskifyApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(TaskifyApiApplication.class, args);
  }

    @Bean
    CommandLineRunner commandLineRunner(TaskAnswerEntityRepository repository){
      return args -> {
          TaskAnswerEntity taskAnswer = new TaskAnswerEntity();
          taskAnswer.setAnswer("answer");
          repository.save(taskAnswer);
      };
    }
}
