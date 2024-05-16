package com.example.taskifyapi.repository;

import com.example.taskifyapi.entity.TaskEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEntityRepository extends JpaRepository<TaskEntity, UUID> {
  Optional<TaskEntity> findByIdAndDeletedIsNull(UUID id);

  List<TaskEntity> findAllByDeletedIsNull();

  List<TaskEntity> findAllByAssignedTo_IdAndDeletedIsNull(UUID userId);
}