package com.example.taskifyapi.repository;

import com.example.taskifyapi.entity.TaskEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
  Optional<TaskEntity> findByIdAndDeletedIsNull(UUID id);
}
