package com.example.taskifyapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
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

  @CreationTimestamp
  @Column(name = "created", nullable = false)
  protected LocalDateTime created;

  @Column(name = "updated")
  protected LocalDateTime updated;

  @Column(name = "deleted")
  protected LocalDateTime deleted;
}
