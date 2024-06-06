package com.example.taskifyapi.entity;

import com.example.taskifyapi.enumeration.UserGender;
import com.example.taskifyapi.enumeration.UserRoles;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "gender", nullable = false)
  @Enumerated(EnumType.STRING)
  UserGender gender;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "user_role", nullable = false)
  @Enumerated(EnumType.STRING)
  private UserRoles role;

  @OneToMany(mappedBy = "assignedTo")
  private List<TaskEntity> assignedTasks;
}
