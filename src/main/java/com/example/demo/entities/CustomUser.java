package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import com.example.demo.entities.Role;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users_1")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column
    public String name;
//    @OneToOne(mappedBy = "user")
//    @JoinColumn(name = "users_1_id")
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ManyToOne
    @JoinColumn(name = "roles_id")
    public Role role;

    @Column
    public String email;
    @Column
    public String password;

    public CustomUser() {}

    public CustomUser(Long id, String name, Role role, String email) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = email;
    }
    public CustomUser(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
