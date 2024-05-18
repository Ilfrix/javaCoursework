package com.example.demo.repositories;

import com.example.demo.entities.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    Optional<CustomUser> findByName(String name);
    Boolean existsByName(String name);
}
