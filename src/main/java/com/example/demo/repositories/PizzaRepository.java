package com.example.demo.repositories;

import com.example.demo.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
//    List<Pizza> findByUser_Id(Long userId);
}
