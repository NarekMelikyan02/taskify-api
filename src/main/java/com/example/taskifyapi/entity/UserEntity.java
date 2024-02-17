package com.example.taskifyapi.entity;

import com.example.taskifyapi.entity.enums.UserGender;
import com.example.taskifyapi.entity.enums.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "gender")// todo add to migration
    @Enumerated(EnumType.STRING)
    UserGender gender;

    @Column(name = "user_role")// todo add to migration
    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @OneToMany(mappedBy = "asignedTo")
    List<TaskEntity> asignedTasks;
}
