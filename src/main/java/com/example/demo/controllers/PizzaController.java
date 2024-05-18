package com.example.demo.controllers;

import com.example.demo.entities.Pizza;
import com.example.demo.repositories.PizzaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    @GetMapping("/")
    public List<Pizza> getPizzas() {
        return pizzaRepository.findAll();
    }
    @PostMapping("/")
    public Pizza createPizza(@RequestBody Pizza newPizza) {
        return pizzaRepository.save(newPizza);
    }

    @DeleteMapping("/{id}")
    public Pizza deletePizza(@PathVariable Long id) {
        try{
            var pizzaOptional = pizzaRepository.findById(id);
            Pizza pizza = pizzaOptional.get();
            pizzaRepository.deleteById(id);

            return pizza;
        } catch (Error e) {
            return null;
        }
    }
}