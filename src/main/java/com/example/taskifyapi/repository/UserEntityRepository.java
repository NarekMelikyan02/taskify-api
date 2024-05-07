package com.example.taskifyapi.repository;

import com.example.taskifyapi.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
  Optional<UserEntity> findByIdAndDeletedIsNull(UUID id);

  List<UserEntity> getAllByDeletedIsNull();

  Optional<UserEntity> getUserEntityByIdAndDeletedIsNull(UUID id);

  Optional<UserEntity> findUserEntityByEmailAndDeletedIsNull(String email);
}
