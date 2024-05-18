package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users_1")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column
    public String name;
    @Column
    public String role;
    @Column
    public String password;

    public CustomUser() {}

    public CustomUser(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    public CustomUser(String name, String role) {
        this.name = name;
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
