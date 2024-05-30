package com.example.taskifyapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  @Column(name = "id", nullable = false, unique = true)
  protected UUID id;

  @Column(name = "created")
  protected LocalDateTime created;

  @Column(name = "updated")
  protected LocalDateTime updated;

  @Column(name = "deleted")
  protected LocalDateTime deleted;
}
