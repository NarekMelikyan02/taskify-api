package com.example.taskifyapi.repository;

import com.example.taskifyapi.entity.TaskAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskAnswerEntityRepository extends JpaRepository<TaskAnswerEntity, UUID> {
    Optional<TaskAnswerEntity> findByIdAndDeletedIsNull(UUID id);
}
