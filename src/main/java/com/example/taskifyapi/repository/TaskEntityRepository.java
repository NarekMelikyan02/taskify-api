package com.example.taskifyapi.repository;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.enumeration.AssignStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskEntityRepository extends JpaRepository<TaskEntity, UUID> {
  Optional<TaskEntity> findByIdAndDeletedIsNull(UUID id);

  List<TaskEntity> findAllByDeletedIsNull();

  List<TaskEntity> findAllByAssignedTo_IdAndStatusIsAndDeletedIsNullOrderByPriority(
      UUID userId, AssignStatus status);
}
