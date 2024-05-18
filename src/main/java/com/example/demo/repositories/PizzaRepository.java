package com.example.demo.repositories;

import com.example.demo.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
