package com.example.TaskManager.models;

import com.example.TaskManager.dto.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @NotBlank
    private String email;

    @Getter @Setter
    @NotBlank
    private String username;

    @Getter @Setter
    @NotBlank
    @Size(min=6)
    private String password;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String email, Role role){
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
