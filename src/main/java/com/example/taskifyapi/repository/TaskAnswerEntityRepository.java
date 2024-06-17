package com.example.taskifyapi.repository;

import com.example.taskifyapi.entity.TaskAnswerEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAnswerEntityRepository extends JpaRepository<TaskAnswerEntity, UUID> {
  Optional<TaskAnswerEntity> findByIdAndDeletedIsNull(UUID id);
}
