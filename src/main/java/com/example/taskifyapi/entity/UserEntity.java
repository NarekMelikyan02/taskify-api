package com.example.taskifyapi.entity;

import com.example.taskifyapi.entity.enums.UserGender;
import com.example.taskifyapi.entity.enums.UserRoles;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "gender", nullable = false)
  @Enumerated(EnumType.STRING)
  UserGender gender;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "user_role", nullable = false)
  @Enumerated(EnumType.STRING)
  private UserRoles role;

  @OneToMany(mappedBy = "assignedTo")
  private List<TaskEntity> assignedTasks;

  public UserEntity() {
    created = LocalDateTime.now();
  }
}
