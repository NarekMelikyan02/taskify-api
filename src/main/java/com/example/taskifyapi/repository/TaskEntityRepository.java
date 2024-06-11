package com.example.taskifyapi.repository;

import com.example.taskifyapi.entity.TaskEntity;
import com.example.taskifyapi.enumeration.AssignStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEntityRepository extends JpaRepository<TaskEntity, UUID> {
  Optional<TaskEntity> findByIdAndDeletedIsNull(UUID id);

  List<TaskEntity> findAllByDeletedIsNull();

  List<TaskEntity> findAllByAssignedTo_IdAndStatusIsAndDeletedIsNull(
      UUID userId, AssignStatus status);

  default void orderByTaskPriority(List<TaskEntity> taskEntityList) {
    taskEntityList.sort(
        (o1, o2) -> Integer.compare(o2.getPriority().getLevel(), o1.getPriority().getLevel()));
  }
}
